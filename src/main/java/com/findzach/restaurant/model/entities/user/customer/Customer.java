package com.findzach.restaurant.model.entities.user.customer;

import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.entities.user.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

    public Customer() {
        setRole("CUSTOMER");
    }
}
