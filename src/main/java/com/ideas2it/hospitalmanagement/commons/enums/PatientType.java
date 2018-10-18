package com.ideas2it.hospitalmanagement.commons.enums;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * PatientType Class is the Enumeration class contains the constant
 * values of types of Patient that can be stored in this Application.
 * <ul>
 * <li>INPATIENT></li>
 * <li>OUTPATIENT</li>
 * </ul>
 *
 * @author Arul Murugan
 * @version 1.0
 */
public enum PatientType {

    INPATIENT("InPatient"), OUTPATIENT("OutPatient");

    private final String value;

    PatientType(final String value) {
        this.value = value;
    }

    public static PatientType fromValue(final int value) {
        for (final PatientType type : values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException(Constants.INVALID_TYPE + value);
    }

    public String toValue() {
        return value;
    }

}
