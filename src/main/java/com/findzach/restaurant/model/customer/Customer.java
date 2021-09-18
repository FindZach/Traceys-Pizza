package com.findzach.restaurant.model.customer;

import com.findzach.restaurant.model.BaseEntity;
import com.findzach.restaurant.model.Role;
import com.findzach.restaurant.model.User;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Entity
public class Customer extends BaseEntity implements User {

    private String firstName, lastName, email;
    private Date birthday;
    private Role role = Role.CUSTOMER;
    private int points;

    /**
     * @return The first name of the specified user
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return The last name of the specified user
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * @return The email of the user
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * @return - Users Birthday
     */
    @Override
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @return - The role of the user
     */
    @Override
    public Role getRole() {
        return role;
    }

    /**
     * @return - Tracking of the user points
     */
    @Override
    public int getPoints() {
        return points;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
