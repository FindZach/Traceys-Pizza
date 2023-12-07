package com.findzach.restaurant.service.user.impl;

import com.findzach.restaurant.model.entities.user.customer.Customer;
import com.findzach.restaurant.model.entities.order.Order;
import com.findzach.restaurant.repository.user.CustomerRepository;
import com.findzach.restaurant.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Will submit an order to the database, to be sent to the restaurant
     *
     * @param customer
     * @param order
     */
    @Override
    public void submitOrder(Customer customer, Order order) {

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //TODO: Error handling
    @Override
    public Customer findById(Long aLong) {
        return customerRepository.findById(aLong).get();
    }

    @Override
    public Customer create(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public boolean delete(Customer object) {
        customerRepository.delete(object);
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
        if (customerRepository.findById(aLong).isPresent()) {
            customerRepository.deleteById(aLong);
            return true;
        } else return false;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }
}
