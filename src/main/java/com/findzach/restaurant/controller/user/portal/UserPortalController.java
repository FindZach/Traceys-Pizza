package com.findzach.restaurant.controller.user.portal;

import com.findzach.restaurant.controller.user.AuthenticatedUserController;
import com.findzach.restaurant.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 11:32 PM
 */
@Controller
@RequestMapping("/user-portal")
public class UserPortalController extends AuthenticatedUserController {

    @Autowired
    public UserPortalController(SessionService sessionService) {
        super(sessionService, "pages/user/user-portal");
    }

    /**
     * @param model
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpSession session) {

        System.out.println("Found User: Last Accessed " + sessionService.getSessionUser(session.getId()).getSessionUserRole());

        return super.showPage(model, session);
    }
}
