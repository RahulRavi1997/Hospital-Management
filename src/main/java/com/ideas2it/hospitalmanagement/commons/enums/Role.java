package com.ideas2it.hospitalmanagement.commons.enums;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * Role is an Enumeration class that consists of all the roles used for Login
 * authorization. It consists of-
 * 
 * <ul>
 * <li>NURSE</li>
 * <li>ADMIN</li>
 * <li>RECEPTIONIST</li>
 * <li>Surgeon</li>
 * <li>PHYSICIAN</li>
 * 
 * @author Rahul Ravi
 * @version 1.0
 */
public enum Role {

    NURSE("NURSE"),

    ADMIN("ADMIN"),

    RECEPTIONIST("RECEPTIONIST"),

    PHYSICIAN("PHYSICIAN");

    private final String value;

    Role(final String value) {
        this.value = value;
    }

    /**
     * This method is used to obtain the enum type from its value.
     * @param value the String value of the enum to be obtained.
     * @return Role the enum to be returned if the value exists.
     */
    public static Role fromValue(final int value) {
        for (final Role role : values()) {
            if (role.value.equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException(Constants.INVALID_ROLE + value);
    }

    /**
     * This method is used to obtain the value of the enum using its identifier.
     * @return String a String indicating the value of the enum variable.
     */
    public String toValue() {
        return value;
    }
}
