package com.findzach.restaurant.repository;

import com.findzach.restaurant.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/17/2021
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
