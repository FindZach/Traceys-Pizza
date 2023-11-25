package com.findzach.restaurant.model.menu;

import com.findzach.restaurant.model.entities.user.Role;

import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
public interface User {

    /**
     *
     * @return The first name of the specified user
     */
    String getFirstName();

    /**
     *
     * @return The last name of the specified user
     */
    String getLastName();

    /**
     *
     * @return The email of the user
     */
    String getEmail();

    /**
     *
     * @return - Users Birthday
     */
    Date getBirthday();

    /**
     *
     * @return - The role of the user
     */
    Role getRole();

    /**
     *
     * @return - Tracking of the user points
     */
    int getPoints();

}
