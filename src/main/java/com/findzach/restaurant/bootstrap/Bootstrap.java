package com.findzach.restaurant.bootstrap;

import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.entities.user.customer.Customer;
import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.repository.EmployeeRepository;
import com.findzach.restaurant.service.CustomerService;
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

    }
}
