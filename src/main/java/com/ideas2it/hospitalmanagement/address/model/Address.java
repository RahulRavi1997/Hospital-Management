package com.ideas2it.hospitalmanagement.address.model;

/**
 * Address class is the Entity class is having the getters and setter methods which is used to get
 * the values from the user. This class acts as an Model for the Address Details.
 *
 * @author Arul Murugan
 * @version 1.0
 */
public class Address {

    private Integer id;
    private String type;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private Long pinCode;
    private Integer patientId;
    private Integer physicianId;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(final Long pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(final Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(final Integer physicianId) {
        this.physicianId = physicianId;
    }
}
