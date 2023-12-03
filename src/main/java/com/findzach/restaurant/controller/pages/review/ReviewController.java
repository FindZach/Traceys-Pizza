package com.findzach.restaurant.controller.pages.review;

import com.findzach.restaurant.controller.pages.PizzaPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 9:56 PM
 */
@Controller
@RequestMapping("reviews")
public class ReviewController implements PizzaPage {

    /**
     * @param model
     * @param session
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpSession session) {
        setDefaults(model);
        return "pages/review";
    }
}
