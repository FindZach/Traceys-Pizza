package com.findzach.restaurant.model.entities.user;

import com.findzach.restaurant.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
