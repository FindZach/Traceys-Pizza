package com.findzach.restaurant.model.menu;

import com.findzach.restaurant.model.BaseEntity;
import com.findzach.restaurant.model.customer.Customer;
import com.findzach.restaurant.model.employee.Employee;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
public class Order extends BaseEntity {

    private Customer customer;

    private Employee employee;

}
