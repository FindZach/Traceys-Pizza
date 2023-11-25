package com.findzach.restaurant.model.entities.user;

import com.findzach.restaurant.model.BaseEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class User extends BaseEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Role role;
    private int points;

    /**
     * @return The first name of the specified user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return The last name of the specified user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return The email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return - Users Birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @return - The role of the user
     */
    public Role getRole() {
        return role;
    }

    /**
     * @return - Tracking of the user points
     */
    public int getPoints() {
        return points;
    }
}
