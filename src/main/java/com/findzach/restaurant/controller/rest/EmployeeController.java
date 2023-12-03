package com.findzach.restaurant.controller.rest;

import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.service.user.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/users/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }
}
