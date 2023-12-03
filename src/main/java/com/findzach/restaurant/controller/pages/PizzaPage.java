package com.findzach.restaurant.controller.pages;

import com.findzach.restaurant.service.attributes.impl.DefaultAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:00 PM
 */
public interface PizzaPage {
    default void setDefaults(Model model) {
        model.addAllAttributes(new DefaultAttributeService().getAll());
    }

    String showPage(Model model, HttpServletRequest httpServletRequest);
}
