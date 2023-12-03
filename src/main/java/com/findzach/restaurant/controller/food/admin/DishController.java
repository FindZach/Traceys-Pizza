package com.findzach.restaurant.controller.food.admin;

import com.findzach.restaurant.controller.pages.PizzaPage;
import com.findzach.restaurant.model.entities.food.Dish;
import com.findzach.restaurant.model.entities.food.FoodItem;
import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.model.entities.food.topping.ToppingQuantity;
import com.findzach.restaurant.model.entities.menu.MenuType;
import com.findzach.restaurant.repository.food.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 4:59 PM
 */
@Controller
@RequestMapping("/dishes")
public class DishController implements PizzaPage {

    @Autowired
    private DishRepository dishService; // You would need to create this service

    @GetMapping("/list")
    public String listDishes(Model model) {
        List<Dish> dishes = dishService.findAll();
        model.addAttribute("dishes", dishes);
        return "/common/fragments/dishes/list"; // Return the HTML template name
    }

    @GetMapping("/add")
    public String showAddDishForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "/common/fragments/dishes/add";
    }

    @PostMapping("/add")
    public String addDish(@ModelAttribute("dish") Dish dish) {
        // Add logic to save the dish to the database using dishService
        System.out.println("Dish: " + dish.getItemName());
        System.out.println("Price: " + dish.getPrice());
        System.out.println("Description: " + dish.getDescription());
        dishService.save(dish);
        return "redirect:/dishes/list"; // Redirect to the list page
    }

    @GetMapping("/edit/{id}")
    public String editDish(@PathVariable Long id, Model model) {
        Optional<Dish> dish = dishService.findById(id); // Replace this with your actual service method to find a dish by ID
        model.addAttribute("dish", dish.get());
        return "/common/fragments/dishes/edit"; // Return the HTML template name for editing
    }


    /**
     * @param model
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model) {
        List<Dish> dishes = new ArrayList<>();
        List<Topping> toppingList = new ArrayList<>();
        List<FoodItem> foodItemList = new ArrayList<>();
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

        FoodItem beefPatty = new FoodItem();
        beefPatty.setPrice(.85);
        beefPatty.setMenuType(MenuType.A_LA_CARTE);

        beefPatty.setItemName("16oz Beef Patty");
        beefPatty.setDescription("100% all beef patty");

        foodItemList.add(beefPatty);

        Dish cheeseburger = new Dish();

        cheeseburger.setComponents(foodItemList);

        cheeseburger.setItemName("Double Cheeseburger");
        cheeseburger.setToppings(toppingList);
        cheeseburger.setPrice(6.15);
        cheeseburger.setDescription("The best cheeseburger in town!");

        dishes.add(cheeseburger);

        model.addAttribute("dishes", dishes);
        return "common/fragments/dishes/index";
    }

    // Similar methods for edit and delete

}

