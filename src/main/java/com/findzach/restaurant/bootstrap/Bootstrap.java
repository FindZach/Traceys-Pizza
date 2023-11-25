package com.findzach.restaurant.bootstrap;

import com.findzach.restaurant.model.entities.food.topping.Topping;
import com.findzach.restaurant.model.entities.food.topping.ToppingQuantity;
import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.entities.user.customer.Customer;
import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.repository.food.FoodItemRepository;
import com.findzach.restaurant.repository.food.ToppingRepository;
import com.findzach.restaurant.repository.user.EmployeeRepository;
import com.findzach.restaurant.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Component
public class Bootstrap implements CommandLineRunner {


    @Autowired
    private EmployeeRepository employeeRepository;
    private FoodItemRepository foodItemRepository;

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
        topping.setPrice(1.50);
        topping.setDescription("Extra Whip Cream!");
        topping.setQuantity(ToppingQuantity.EXTRA);

        toppingRepository.save(topping);

    }
}
