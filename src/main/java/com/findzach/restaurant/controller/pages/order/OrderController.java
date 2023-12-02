package com.findzach.restaurant.controller.pages.order;

import com.findzach.restaurant.controller.pages.PizzaPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 2:08 PM
 */
@Controller
public class OrderController implements PizzaPage {

    @GetMapping("order")
    @Override
    public String showPage(Model model, HttpServletRequest httpServletRequest) {
        return "order";
    }
}
