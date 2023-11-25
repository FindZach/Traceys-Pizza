package com.findzach.restaurant.model.entities.order;

import com.findzach.restaurant.model.BaseEntity;
import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.model.menu.User;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
public class Order extends BaseEntity {

    private User customer;
    private Employee leadEmployee;
}
