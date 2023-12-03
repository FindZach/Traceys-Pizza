package com.findzach.restaurant.controller.pages.review;

import com.findzach.restaurant.controller.BaseController;
import com.findzach.restaurant.controller.pages.PizzaPage;
import com.findzach.restaurant.service.session.SessionService;
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
public class ReviewController extends BaseController {

    public ReviewController(SessionService sessionService) {
        super(sessionService, "pages/review");
    }

    /**
     * @param model
     * @param session
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpSession session) {
        return super.showPage(model, session);
    }
}
