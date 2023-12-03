package com.findzach.restaurant.controller.pages;

import com.findzach.restaurant.service.attributes.impl.DefaultAttributeService;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:00 PM
 */
public interface PizzaPage {

    default void setDefaults(Model model, DefaultAttributeService defaultAttributeService) {
        model.addAllAttributes(defaultAttributeService.getAll());
    }

    String showPage(Model model, HttpSession session);

}
