package com.findzach.restaurant.service.user.impl;

import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.repository.user.EmployeeRepository;
import com.findzach.restaurant.service.user.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee create(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public boolean delete(Employee object) {
        employeeRepository.delete(object);
        return true;
    }

    /**
     * Deletes Object , finds with ID
     *
     * @param aLong - The ID of the object
     * @return - True if deleted, false if no record exists
     */
    @Override
    public boolean deleteById(Long aLong) {
        if (employeeRepository.existsById(aLong)) {
            employeeRepository.deleteById(aLong);
            return true;
        }
        return false;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    /**
     * @param username
     * @return
     */
    public Employee findByUsername(String username) {
        return employeeRepository.findEmployeeByUsername(username);
    }
}
