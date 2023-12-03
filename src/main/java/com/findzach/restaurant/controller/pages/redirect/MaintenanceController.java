package com.findzach.restaurant.controller.pages.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Zach Smith
 * @date: 11/25/2023
 * @time: 12:45 PM
 */
@Controller
public class MaintenanceController {

    @GetMapping("maintenance")
    public String showUnderMaintenance() {
        return "common/redirects/under-maintenance";
    }
}
