package com.findzach.restaurant.controller.pages;

import com.findzach.restaurant.controller.pages.PizzaPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 8:47 PM
 */
@RequestMapping("contact")
@Controller
public class ContactController implements PizzaPage {
    /**
     * @param model
     * @param httpServletRequest
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpServletRequest httpServletRequest) {
        setDefaults(model);

        return "contact-us";
    }
}
