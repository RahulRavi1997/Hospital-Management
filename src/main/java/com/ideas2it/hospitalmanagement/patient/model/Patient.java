package com.ideas2it.hospitalmanagement.patient.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ideas2it.hospitalmanagement.address.model.Address;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.physician.model.Physician;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Patient class is the Patient class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the Patient Details.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class Patient {

	private Integer id;
    private String firstName;
    private String lastName;
    private String emailId;
	private Long mobileNumber;
    private Date birthDate;
    private List<Address> addresses = new ArrayList<Address>();
    private boolean active;
	private String gender;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
        @DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public List<Address> getAddress() {
		return addresses;
	}
	public void setAddress(List<Address> addresses) {
		this.addresses = addresses;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
