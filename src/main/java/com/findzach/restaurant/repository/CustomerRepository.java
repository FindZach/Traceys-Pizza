package com.findzach.restaurant.repository;

import com.findzach.restaurant.model.entities.user.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
