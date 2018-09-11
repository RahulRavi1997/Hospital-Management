package com.ideas2it.hospitalmanagement.address.model;

<<<<<<< HEAD
public class Address {

    private String AddressLine1;
    private String AddressLine2;
    private String country;
    private Long pinCode;
    
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
}
=======
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
    private Integer doorNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private Long pincode;
    private String addressType;
	private Integer personId;

    // Getters and Setters for Address Model.
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoorNumber() {
        return this.doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPincode() {
        return this.pincode = pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getAddressType() {
        return this.addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

    /**
     * This Method is to Override the equals method and it compares to the
     * object having same value.
     *
     * @return  true     when the address object is the same.
     *          false    when the address object is not equal.
     */
    @Override
    public boolean equals(Object addr) {
	if (null == addr) {
	    return Boolean.FALSE;
	}

	if (getClass() != addr.getClass()) {
            return Boolean.FALSE;
	}

	Address address = (Address) addr;
	return (this.getId() == address.getId());
    }

    /**
     * This Method is to Override the Hashcode value and it is compared to the
     * object having same value and hashCode method returns the same
     * hashcode value for object having same values.
     *
     * @return  result   an int datatype containing the HashCode value of
     *                   the object.
     */
    @Override
    public int hashCode() {

        final int prime = 17;
	int result = 1;
	result = prime * result + getId();
	return result;
    }
}
>>>>>>> 3f1ff0fbab14d171f5277e78a41d0884a124d1e2
