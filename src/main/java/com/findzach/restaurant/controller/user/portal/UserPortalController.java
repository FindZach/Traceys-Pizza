package com.findzach.restaurant.controller.user.portal;

import com.findzach.restaurant.controller.pages.PizzaPage;
import com.findzach.restaurant.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 11:32 PM
 */
@Controller
@RequestMapping("/user-portal")
public class UserPortalController implements PizzaPage {

    @Autowired
    private SessionService sessionService;

    /**
     * @param model
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpSession session) {
        setDefaults(model);

        System.out.println("Found User: Last Accessed " + sessionService.getSessionUser(session.getId()).getUserId());
        return "pages/user-portal";
    }
}
