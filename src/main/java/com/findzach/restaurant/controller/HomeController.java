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
import java.util.List;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private SessionService service;

    private List<Topping> toppingList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        // Your code here\
        System.out.println("Visiting home! " + request.getSession().getId());

        formToppingsList();

        model.addAttribute("toppingsList", toppingList);

        return "index"; // No leading slash
    }

    private void formToppingsList() {
        if (toppingList.isEmpty()) {

            Topping cheese = new Topping();
            Topping tomato = new Topping();
            Topping relish = new Topping();
            Topping mayo = new Topping();
            Topping mustard = new Topping();

            toppingList.add(cheese);
            toppingList.add(tomato);
            toppingList.add(relish);
            toppingList.add(mayo);
            toppingList.add(mustard);

            cheese.setItemName("Cheese");
            cheese.setPrice(.75);

            tomato.setItemName("Tomato");
            tomato.setPrice(.75);

            relish.setItemName("Relish");
            relish.setPrice(.75);

            mayo.setItemName("Mayo");
            mayo.setPrice(.75);

            mustard.setItemName("Mustard");
            mustard.setPrice(.75);

        }
    }
}
