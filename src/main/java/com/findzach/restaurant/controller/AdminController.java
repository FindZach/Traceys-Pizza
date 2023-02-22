package com.findzach.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@CrossOrigin(maxAge = 3600)
@Controller
public class AdminController {


    @GetMapping("/admin")
    public String viewAdminPage() {

        return "admin";
    }

}
