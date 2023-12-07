package com.findzach.restaurant.repository.user;

import com.findzach.restaurant.model.entities.user.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/17/2021
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByUsername(String username);
}
