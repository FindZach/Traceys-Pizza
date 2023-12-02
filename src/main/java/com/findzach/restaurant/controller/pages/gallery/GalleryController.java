package com.findzach.restaurant.controller.pages.gallery;

import com.findzach.restaurant.controller.pages.PizzaPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 1:59 PM
 */
@Controller
public class GalleryController implements PizzaPage {

    @GetMapping("gallery")
    public String showPage(Model model, HttpServletRequest httpServletRequest) {
        return "gallery";
    }
}
