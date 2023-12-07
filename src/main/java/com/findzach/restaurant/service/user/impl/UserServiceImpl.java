package com.findzach.restaurant.service.user.impl;

import com.findzach.restaurant.model.entities.user.User;
import com.findzach.restaurant.model.entities.user.customer.Customer;
import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.service.user.CustomerService;
import com.findzach.restaurant.service.user.EmployeeService;
import com.findzach.restaurant.service.user.UserCrudService;
import com.findzach.restaurant.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zach Smith
 * @date: 12/6/2023
 * @time: 9:31 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private final CustomerService customerService;
    private final EmployeeService employeeService;

    @Autowired
    public UserServiceImpl(CustomerService customerService, EmployeeService employeeService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
    }
    /**
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();

        // Fetch and add customers to the list
        List<Customer> customers = customerService.findAll();
        allUsers.addAll(customers);

        // Fetch and add employees to the list
        List<Employee> employees = employeeService.findAll();
        allUsers.addAll(employees);

        return allUsers;
    }

    /**
     * @param aLong
     * @return
     */
    @Override
    public User findById(Long aLong) {
        return customerService.findById(aLong) != null ? customerService.findById(aLong) : employeeService.findById(aLong);
    }

    /**
     * @param user - the requested user for creation
     * @return
     */
    @Override
    public User create(User user) {
        return (User) getUserService(user).create(user);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean delete(User object) {
        return getUserService(object).delete(object);
    }

    /**
     * @param aLong - The ID of the object
     * @return
     */
    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public User save(User object) {
        return (User) getUserService(object).save(object);
    }

    /**
     * @return
     */
    @Override
    public UserCrudService getUserService(User user) {
        System.out.println("Class of user: " + user.getClass().getName());

        if (user instanceof Employee) {
            System.out.println("User is an employee instance");
            return employeeService;
        }
        System.out.println("We've not detected an employee with object: " + user.toString());
        return customerService;
    }

    /**
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        User foundCustomer = customerService.findByUsername(username);
        if (foundCustomer != null) {
            return foundCustomer;
        }
        User foundEmployee = employeeService.findByUsername(username);
        return foundEmployee;
    }
}
