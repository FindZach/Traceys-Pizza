package com.findzach.restaurant.controller.pages.gallery;

import com.findzach.restaurant.controller.BaseController;
import com.findzach.restaurant.controller.pages.PizzaPage;
import com.findzach.restaurant.service.session.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 1:59 PM
 */
@Controller
public class GalleryController extends BaseController {

    public GalleryController(SessionService sessionService) {
        super(sessionService, "pages/gallery");
    }

    @GetMapping("gallery")
    public String showPage(Model model, HttpSession session) {
        return super.showPage(model, session);
    }
}
