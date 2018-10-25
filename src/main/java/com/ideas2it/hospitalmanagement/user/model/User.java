package com.ideas2it.hospitalmanagement.user.model;

/**
 * User class is the Entity class which is used to store and retrieve the details of
 * a user. Each user has a unique Email Id and a password for authentication
 * purposes. An Active attribute is provided to implement soft deletion.
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public class User {

    private Integer id;
    private String email;
    private String password;
    private String role;
    private boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }
}