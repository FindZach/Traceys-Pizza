package com.findzach.restaurant.interceptor;

import com.findzach.restaurant.controller.HomeController;
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
import java.util.Set;

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
    private SessionService service;

    /**
     * We don't want spammed calculations from static dir
     */
    private final List<String> urlsEntryToIgnore = Arrays.asList("/images/", "/resources/", "error");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if (service.findById(session.getId()) == null) {
            service.create(new SessionUser(session));
            log.info("Service created new SessionUser");
            response.sendRedirect("/login");
            return false;
        } else {
            if (!ignoreUrl(request.getRequestURI())) {
                SessionUser currentUser = service.findById(session.getId());
                log.info("Visiting URL: " + request.getRequestURI());
                log.info("Found Session User: " + currentUser.getSession().getLastAccessedTime());
            }
        }
        // Your session validation logic here
        // If the session is valid, return true; otherwise, return false.
        // You can also redirect to a login page if the session is not valid.
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