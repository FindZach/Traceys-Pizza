package com.findzach.restaurant.controller.pages.order;

import com.findzach.restaurant.controller.pages.PizzaPage;
import com.findzach.restaurant.model.entities.food.Dish;
import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.model.entities.food.topping.ToppingQuantity;
import com.findzach.restaurant.model.entities.menu.MenuType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        List<Dish> dishes = new ArrayList<>();
        List<Topping> toppingList = new ArrayList<>();
        Topping mustard = new Topping();
        mustard.setPrice(0);
        mustard.setQuantity(ToppingQuantity.NORMAL);
        mustard.setMenuType(MenuType.TOPPING);
        mustard.setItemName("Mustard");
        toppingList.add(mustard);

        Topping cheese = new Topping();
        cheese.setItemName("Swiss Cheese");
        cheese.setMenuType(MenuType.TOPPING);
        cheese.setQuantity(ToppingQuantity.NORMAL);
        toppingList.add(cheese);

        Topping bacon = new Topping();
        bacon.setItemName("Bacon");
        bacon.setMenuType(MenuType.TOPPING);
        bacon.setQuantity(ToppingQuantity.NORMAL);
        bacon.setPrice(.75);
        toppingList.add(bacon);

        Dish cheeseburger = new Dish();

        cheeseburger.setItemName("Cheeseburger");
        cheeseburger.setToppings(toppingList);
        cheeseburger.setPrice(6.15);
        cheeseburger.setDescription("The best cheeseburger in town!");

        dishes.add(cheeseburger);

        model.addAttribute("dishes", dishes);

        System.out.println("Adding cheeseburger : " + cheeseburger.getItemName());


        return "order";
    }
}
