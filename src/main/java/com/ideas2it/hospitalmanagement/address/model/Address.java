package com.ideas2it.hospitalmanagement.address.model;

/**
 * Address class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the Address Details.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class Address {

	private Integer id;
	private String AddressLine1;
    private String AddressLine2;
    private String country;
    private Long pinCode;
	private Integer physicianId;
    private Integer patientId;
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
    public Integer getPhysicianId() {
		return physicianId;
	}
	public void setPhysicianId(Integer physicianId) {
		this.physicianId = physicianId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
}
