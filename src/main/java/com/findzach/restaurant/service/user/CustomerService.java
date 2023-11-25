package com.findzach.restaurant.service.user;

import com.findzach.restaurant.model.entities.user.customer.Customer;
import com.findzach.restaurant.model.entities.order.Order;
import com.findzach.restaurant.service.CrudService;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/17/2021
 */
public interface CustomerService extends CrudService<Customer, Long> {

    /**
     * Will submit an order to the database, to be sent to the restaurant
     * @param customer
     * @param order
     */
    void submitOrder(Customer customer, Order order);
}
