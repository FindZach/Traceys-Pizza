package com.findzach.restaurant.interceptor;

import com.findzach.restaurant.config.Constants;
import com.findzach.restaurant.config.WebStatus;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.session.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Zach Smith
 * @date: 11/25/2023
 * @time: 12:22 PM
 *
 * Sustains state of our Session/Active users - Auto removes from map after 15 minutes
 */
@Component
public class SessionValidationInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(SessionValidationInterceptor.class);
    @Autowired
    private SessionService sessionService;

    /**
     * We don't want spammed calculations from static dir
     */
    private final List<String> urlsEntryToIgnore = Arrays.asList("/images/", "/resources/", "error");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (Constants.CURRENT_STATUS == WebStatus.UNDER_MAINTENANCE) {
            if (request.getRequestURI().equalsIgnoreCase("/maintenance")) {
                return true;
            }
            response.sendRedirect("maintenance");
        }

        HttpSession session = request.getSession();
        if (sessionService.findById(session.getId()) == null) {
            sessionService.create(new SessionUser(session));
            log.info("Service created new SessionUser");
        } else {
            if (!ignoreUrl(request.getRequestURI())) {
                SessionUser currentUser = sessionService.findById(session.getId());
                log.info("Visiting URL: " + request.getRequestURI());
                log.info("Found Session User: " + currentUser.getSession().getLastAccessedTime());
            }
        }
        return true;
    }

    private boolean ignoreUrl(String url) {
        for (String ignoreStart: urlsEntryToIgnore) {
            if (url.isBlank() || url.contains(ignoreStart)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // This method is called after the controller method has been invoked but before the view is rendered.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // This method is called after the view has been rendered.
    }
}