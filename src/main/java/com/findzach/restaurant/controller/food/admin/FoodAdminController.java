package com.findzach.restaurant.controller.food.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Zach Smith
 * @date: 11/24/2023
 * @time: 10:28 PM
 */
@Controller
public class FoodAdminController {


    @GetMapping("admin/food/editor")
    public String viewAdminEditor() {
        return "food/admin/FoodCreator";
    }
}
