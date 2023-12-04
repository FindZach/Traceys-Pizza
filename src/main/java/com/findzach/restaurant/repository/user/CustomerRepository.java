package com.findzach.restaurant.repository.user;

import com.findzach.restaurant.model.entities.user.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByUsername(String username);
}
