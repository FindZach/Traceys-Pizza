package com.findzach.restaurant.controller;

import com.findzach.restaurant.controller.pages.PizzaPage;
import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.attributes.impl.DefaultAttributeService;
import com.findzach.restaurant.service.session.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 1:16 AM
 */
public abstract class BaseController implements PizzaPage {

    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
    protected final SessionService sessionService;
    protected final String baseTemplateRoute;

    @Autowired
    private DefaultAttributeService defaultAttributeService;

    @Autowired
    public BaseController(SessionService sessionService, String baseTemplateRoute) {
        this.sessionService = sessionService;
        this.baseTemplateRoute = baseTemplateRoute;
    }

    @Override
    public String showPage(Model model, HttpSession session) {
        SessionUser sessionUser = sessionService.getSessionUser(session.getId());
        setDefaults(model, defaultAttributeService);

        if (sessionUser != null && sessionUser.getSessionUserRole() != null && sessionUser.getSessionUserRole() != Role.GUEST) {
            model.addAttribute("loginState", "Logout");
            //TODO: Perhaps make this its own service down the road
        } else if(sessionUser != null && (sessionUser.isRequestedLogout())) {
            model.addAttribute("invalidSession", true);
        }
        return baseTemplateRoute;
    }

    public SessionService getSessionService() {
        return sessionService;
    }

    public String getBaseTemplateRoute() {
        return baseTemplateRoute;
    }
}
