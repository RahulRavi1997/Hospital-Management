package com.ideas2it.hospitalmanagement.commons.enums;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * Gender Class is the Enumeration class contains the constant
 * values of types of Gender that can be stored in this Application.
 * <ul>
 * <li>Male></li>
 * <li>Female</li>
 * <li>Other</li>
 * </ul>
 *
 * @author Arul Murugan
 * @version 1.0
 */
public enum Gender {

    Male("Male"), Female("Female"), Other("Other");

    private final String value;

    Gender(final String value) {
        this.value = value;
    }

    public static Gender fromValue(final int value) {
        for (final Gender gender : values()) {
            if (gender.value.equals(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException(Constants.INVALID_GENDER + value);
    }

    public String toValue() {
        return value;
    }

}
