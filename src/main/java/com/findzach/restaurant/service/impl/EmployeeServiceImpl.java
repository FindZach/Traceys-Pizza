package com.findzach.restaurant.service.impl;

import com.findzach.restaurant.model.employee.Employee;
import com.findzach.restaurant.repository.EmployeeRepository;
import com.findzach.restaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Set<Employee> findAll() {
        return Set.copyOf(employeeRepository.findAll());
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
}
