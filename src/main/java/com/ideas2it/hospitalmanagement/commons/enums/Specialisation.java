package com.ideas2it.hospitalmanagement.commons.enums;

public enum Specialisation {

    Cardiologist("Cardiologist"), Neurologist("Neurologist"), Ophthalmologist("Ophthalmologist"), Surgeon("Surgeon"),
    Pediatrician("Pediatrician"), Dermatologist("Dermatologist"), Immunologist("Immunologist"),
    Psychiatrist("Psychiatrist");

    private final String value;

    Specialisation(final String value) {
        this.value = value;
    }

    public static Specialisation fromValue(final int value) {
        for (final Specialisation specialisation : values()) {
            if (specialisation.value.equals(value)) {
                return specialisation;
            }
        }
        throw new IllegalArgumentException("Invalid specialisation: " + value);
    }

    public String toValue() {
        return value;
    }
}