package com.findzach.restaurant.controller;

import com.findzach.restaurant.service.session.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController extends BaseController {

    public HomeController(SessionService sessionService) {
        super(sessionService, "index");
    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        return showPage(model, request.getSession()); // No leading slash
    }

    @GetMapping("/test")
    public String viewSkeleton(Model model, HttpSession session) {
        return "skeleton";
    }

}
