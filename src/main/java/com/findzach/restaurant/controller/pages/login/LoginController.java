package com.findzach.restaurant.controller.pages.login;

import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private final SessionService sessionService;

    public LoginController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        SessionUser sessionUser = sessionService.findById(session.getId());
        if (sessionUser != null) {
            sessionUser.setRole(Role.GUEST);
            sessionUser.setRequestedLogout(true);
        }
        return "redirect:/login";
    }

    @GetMapping("/login2")
    public String login2() {
        return "common/fragments/login";
    }

    @PostMapping("/login")
    public String loginAttempt(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Add your authentication logic here

        if (sessionService.getSessionUser(session.getId()) != null)
            sessionService.getSessionUser(session.getId()).setRole(Role.CUSTOMER);
        return "redirect:/user-portal"; // Redirect to the list page
    }

}