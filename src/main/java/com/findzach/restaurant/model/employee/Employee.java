package com.findzach.restaurant.model.employee;

import com.findzach.restaurant.model.BaseEntity;
import com.findzach.restaurant.model.Role;
import com.findzach.restaurant.model.User;
import com.findzach.restaurant.model.Workable;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Entity
public class Employee extends BaseEntity implements User, Workable {

    /*
     * The employees firstname
     */
    private String firstName;
    private String lastName;
    private String email;

    private Date birthday;

    private Role role;
    private int points;

    /*
     * True if Employee is clocked in, false if Employee is not clocked in
     */
    private boolean clockedIn;

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

    /**
     * Checks Work Status
     *
     * @return - True if working, false if not working
     */
    @Override
    public boolean isWorking() {
        return false;
    }

    /**
     * Will adjust the Employees' Status and update the proper fields
     *
     * @return True if shift is beginning, false if shift is ending.
     */
    @Override
    public boolean toggleWork() {
        return false;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
