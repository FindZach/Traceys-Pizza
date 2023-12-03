package com.findzach.restaurant.controller.pages.contact;

import com.findzach.restaurant.controller.pages.PizzaPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
     * @param session
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpSession session) {
        setDefaults(model);
        return "pages/contact-us";
    }

    @PostMapping
    public String contactRequest(@RequestParam("fullname") String fullname, @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             @RequestParam("message") String message) {

        // TODO: Create Ticket object
        return "pages/contact-us";
    }
}