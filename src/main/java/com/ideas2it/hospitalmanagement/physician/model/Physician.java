package com.ideas2it.hospitalmanagement.physician.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.ideas2it.hospitalmanagement.address.model.Address;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.utils.DateUtil;

/**
 * Physician is an Entity class which is used to store and retrieve the details of a
 * physician. A Physician can have multiple addresses and a user Login. 
 * Active field is provided to implement soft deletion.
 * 
 * @author Rahul Ravi
 * @version 1.0
 *
 */
public class Physician {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Long mobileNumber;
    private String email;
    private String gender;
    private String specialisation;
    private boolean active;
    private User user;
    private List<Address> addresses = new ArrayList<Address>();

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
    @DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
    public Date getBirthDate() {
        return birthDate;
    }

    @DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(final String specialisation) {
        this.specialisation = specialisation;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public Integer getAge() {
        return DateUtil.getYearDifference(this.birthDate);
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }
}
