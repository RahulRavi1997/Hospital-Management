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
    private String userName;
    private String emailId;
    private String role;
    private boolean active;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return userName;
	}

	public void setFirstName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}