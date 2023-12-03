package com.findzach.restaurant.controller;

import com.findzach.restaurant.controller.pages.PizzaPage;
import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 1:16 AM
 */
public abstract class BaseController implements PizzaPage {

    protected final SessionService sessionService;
    protected final String baseTemplateRoute;

    @Autowired
    public BaseController(SessionService sessionService, String baseTemplateRoute) {
        this.sessionService = sessionService;
        this.baseTemplateRoute = baseTemplateRoute;
    }

    @Override
    public String showPage(Model model, HttpSession session) {
        setDefaults(model);
        SessionUser sessionUser = sessionService.getSessionUser(session.getId());
        if (sessionUser != null && sessionUser.getSessionUserRole() != null && sessionUser.getSessionUserRole() != Role.GUEST) {
            model.addAttribute("loginState", "Logout");
        } else {
            model.addAttribute("loginState", "Login | Join");
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
