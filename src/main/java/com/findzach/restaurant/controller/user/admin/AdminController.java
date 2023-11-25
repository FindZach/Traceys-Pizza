package com.findzach.restaurant.controller.user.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@CrossOrigin(maxAge = 3600)
@Controller
public class AdminController {

    boolean isAdmin = true;

    @GetMapping("/admin")
    public String viewAdminPage(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("authenticated", true);

        System.out.println("User Session Data: " + session.getId());
        System.out.println("User Session Data: " + session.getAttribute("authenticated"));

        if (!isAdmin) {
            return "404";
        }

        model.addAttribute("", "");
        System.out.println("New Updates!");
        return "admin";
    }

}
