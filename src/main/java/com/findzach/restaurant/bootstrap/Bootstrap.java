package com.findzach.restaurant.bootstrap;

import com.findzach.restaurant.model.entities.food.Dish;
import com.findzach.restaurant.model.entities.food.FoodItem;
import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.model.entities.food.topping.ToppingQuantity;
import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.entities.user.customer.Customer;
import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.model.entities.menu.MenuType;
import com.findzach.restaurant.repository.food.DishRepository;
import com.findzach.restaurant.repository.food.FoodItemRepository;
import com.findzach.restaurant.repository.food.ToppingRepository;
import com.findzach.restaurant.repository.user.EmployeeRepository;
import com.findzach.restaurant.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Component
public class Bootstrap implements CommandLineRunner {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private CustomerService customerService;

    /**
     * Create Dummy Accounts for Testing purposes.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        /*
        Employee employee = new Employee();

        employee.setBirthday(new Date());
        employee.setFirstName("Zachary");
        employee.setLastName("Smith");
        employee.setEntityCreationDate(new Date());
        employee.setRole(Role.EMPLOYEE);

        employeeRepository.save(employee);

        Customer customer = new Customer();

        customer.setFirstName("Bret");
        customer.setLastName("Bock");
        customer.setEmail("bills@bills.com");
        customer.setRole(Role.CUSTOMER);

        customerService.create(customer);

        Topping topping = new Topping();

        topping.setItemName("Extra Whip Cream");
        topping.setPrice(.50);
        topping.setDescription("Extra Whip Cream!");
        topping.setQuantity(ToppingQuantity.EXTRA);

        toppingRepository.save(topping);

        FoodItem foodItem = new FoodItem();

        foodItem.setItemName("Pumpkin Pie");
        foodItem.setMenuType(MenuType.DESSERT);
        foodItem.setPrice(3.50);

        foodItemRepository.save(foodItem);

        Dish dish = new Dish();

        dish.setItemName("Pumpkin Pie Special");
        dish.setMenuType(MenuType.SPECIAL);
        dish.setPrice(foodItem.getPrice() + topping.getPrice());
        dish.setComponents(Arrays.asList(foodItem));
        dish.setToppings(Arrays.asList(topping));

        dishRepository.save(dish);

        List<Topping> toppings = new ArrayList<>();

        Topping cheese = new Topping();
        Topping tomato = new Topping();
        Topping relish = new Topping();
        Topping mayo = new Topping();
        Topping mustard = new Topping();
        toppings.add(cheese);
        toppings.add(tomato);
        toppings.add(relish);
        toppings.add(mayo);
        toppings.add(mustard);
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

        toppingRepository.saveAll(toppings);

         */

    }
}
