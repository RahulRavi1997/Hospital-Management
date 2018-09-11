package com.ideas2it.hospitalmanagement.user.model;

import java.util.Date;

import com.ideas2it.hospitalmanagement.address.model.Address;
import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * User class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the User Details.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class User {

	private Integer id ;
    private String email;
    private String password;
    private String role;
    private Boolean active;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
