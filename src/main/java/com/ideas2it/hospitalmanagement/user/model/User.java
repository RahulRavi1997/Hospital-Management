package com.ideas2it.hospitalmanagement.user.model;

/**
 * User class is the Entity class is having the getters and setter methods which is used to get the
 * values from the user. This class acts as an Model for the User Details.
 *
 * @author Arul Murugan
 * @version 1.0
 */
public class User {

    private Integer id;
    private String email;
    private String password;
    private String role;
    private Boolean active;

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

    public Boolean isActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }
}
