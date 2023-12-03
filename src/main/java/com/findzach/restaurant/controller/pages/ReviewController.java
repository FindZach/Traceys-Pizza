package com.findzach.restaurant.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 9:56 PM
 */
@Controller
@RequestMapping("reviews")
public class ReviewController implements PizzaPage{

    /**
     * @param model
     * @param httpServletRequest
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpServletRequest httpServletRequest) {
        setDefaults(model);
        return "review";
    }
}
