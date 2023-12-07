package com.findzach.restaurant.model.entities.user.employee;

import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.entities.user.Workable;
import com.findzach.restaurant.model.entities.user.User;
import com.findzach.restaurant.model.entities.user.customer.Customer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Customer implements Workable {

    private Role role = Role.EMPLOYEE;

    /**
     * @return
     */
    @Override
    public boolean isWorking() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean toggleWork() {
        return false;
    }
}
