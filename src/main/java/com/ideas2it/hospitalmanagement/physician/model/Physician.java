package com.ideas2it.hospitalmanagement.physician.model;

import java.util.List;
import java.util.Date;

import  com.ideas2it.hospitalmanagement.patient.model.Patient;

public class Physician {

	private Integer id;
	private String firstName;
	private String lastName;
    private String email;
    private Date birthDate;
    public enum Gender{
        Male,
        Female,
        Other;

    	private String gender;

        public String getGender() {
            return gender;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
    }
    private Long mobileNumber;
    private Address address;
	private String specialisation;
	private List<Patient> patients;
	private Boolean active;
	private Integer userId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
