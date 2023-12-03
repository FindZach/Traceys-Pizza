package com.findzach.restaurant.controller;

import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.session.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class HomeController extends BaseController {

    public HomeController(SessionService sessionService) {
        super(sessionService, "index");
    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        return showPage(model, request.getSession()); // No leading slash
    }

}
