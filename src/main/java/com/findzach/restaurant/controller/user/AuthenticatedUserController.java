package com.findzach.restaurant.controller.user;

import com.findzach.restaurant.controller.BaseController;
import com.findzach.restaurant.service.session.SessionService;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 1:09 AM
 */
public abstract class AuthenticatedUserController extends BaseController {

    public AuthenticatedUserController(SessionService sessionService, String baseTemplateRoute) {
        super(sessionService, baseTemplateRoute);
    }

    @Override
    public String showPage(Model model, HttpSession session) {
        if (!isAuthenticated(session) || sessionService.getSessionUser(session.getId()).getUser() == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", sessionService.getSessionUser(session.getId()).getUser());
        return super.showPage(model, session);
    }

    protected boolean isAuthenticated(HttpSession session) {
        return sessionService.isAuthenticated(session);
    }
}
