package com.ideas2it.hospitalmanagement.commons.enums;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * Specialization is an Enumeration class that consists of all the specializations
 * that can be assigned to a Physician. It consists of-
 * <ul>
 * <li>Cardiologist</li>
 * <li>Neurologist</li>
 * <li>Ophthalmologist</li>
 * <li>Surgeon</li>
 * <li>Pediatrician</li>
 * <li>Dermatologist</li>
 * <li>Immunologist</li>
 * <li>Psychiatrist</li>
 * </ul>
 * 
 * @author Rahul Ravi
 * @version 1.0
 */
public enum Specialisation {

    Cardiologist("Cardiologist"),
    
    Neurologist("Neurologist"),
    
    Ophthalmologist("Ophthalmologist"),
    
    Surgeon("Surgeon"),
    
    Pediatrician("Pediatrician"),
    
    Dermatologist("Dermatologist"),
    
    Immunologist("Immunologist"),
    
    Psychiatrist("Psychiatrist");

    private final String value;

    Specialisation(final String value) {
        this.value = value;
    }

    /**
     * This method is used to obtain the enum type from its value.
     * @param value the String value of the enum to be obtained.
     * @return Specialisation the enum to be returned if the value exists.
     */
    public static Specialisation fromValue(final int value) {
        for (final Specialisation specialisation : values()) {
            if (specialisation.value.equals(value)) {
                return specialisation;
            }
        }
        throw new IllegalArgumentException(Constants.INVALID_SPECIALISATION + value);
    }

    /**
     * This method is used to obtain the value of the enum using its identifier.
     * @return String a String indicating the value of the enum variable.
     */
    public String toValue() {
        return value;
    }
}
