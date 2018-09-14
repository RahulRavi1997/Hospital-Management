package com.ideas2it.hospitalmanagement.commons.enums;

public enum Gender {

    Male("Male"), Female("Female"), Other("Other");

    private final String value;

    Gender(String value){
        this.value = value;
    }

    public static Gender fromValue(int value){
        for (Gender gender : values()) {  
            if (gender.value.equals(value)) {  
                return gender;  
            }  
        }
        throw new IllegalArgumentException("Invalid gender: " + value);  
    }

    public String toValue() {
        return value;
    }

}
