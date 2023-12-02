package com.findzach.restaurant.controller.pages;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:00 PM
 */
public interface PizzaPage {

    String showPage(Model model, HttpServletRequest httpServletRequest);
}
