package com.findzach.restaurant.controller.pages.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/login2")
    public String login2() {
        return "common/fragments/login";
    }

    @PostMapping("/login")
    public String loginAttempt(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Add your authentication logic here

        return "redirect:/user-portal"; // Redirect to the list page
    }

}