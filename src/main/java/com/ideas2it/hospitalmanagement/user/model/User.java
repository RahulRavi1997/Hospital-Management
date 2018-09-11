package com.ideas2it.hospitalmanagement.user.model;

import java.util.Date;

import com.ideas2it.hospitalmanagement.address.model.Address;
import com.ideas2it.hospitalmanagement.commons.Constants;

<<<<<<< HEAD

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Person class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the Person Details.
=======
/**
 * User class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the User Details.
>>>>>>> 3f1ff0fbab14d171f5277e78a41d0884a124d1e2
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class User {

	private Integer id ;
<<<<<<< HEAD
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
=======
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
>>>>>>> 3f1ff0fbab14d171f5277e78a41d0884a124d1e2
