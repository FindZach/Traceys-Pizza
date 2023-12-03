package com.findzach.restaurant.controller.pages.login;

import com.findzach.restaurant.controller.BaseController;
import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController extends BaseController {

    @Autowired
    private final SessionService sessionService;

    public LoginController(SessionService sessionService) {
        super(sessionService, "pages/login");
        this.sessionService = sessionService;
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        return super.showPage(model, session);
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {

        SessionUser sessionUser = sessionService.findById(session.getId());
        if (sessionUser != null) {
            sessionUser.setRole(Role.GUEST);
            sessionUser.setRequestedLogout(true);
        }

        return "redirect:/" + "";
    }

    @PostMapping("/login")
    public String loginAttempt(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Add your authentication logic here

        if (sessionService.getSessionUser(session.getId()) != null)
            sessionService.getSessionUser(session.getId()).setRole(Role.DEVELOPER);

        return "redirect:/user-portal"; // Redirect to the list page
    }

}