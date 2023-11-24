package com.findzach.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        // Your code here\
        System.out.println("Visiting home! " + request.getSession().getId());
        return "index"; // No leading slash
    }
}
