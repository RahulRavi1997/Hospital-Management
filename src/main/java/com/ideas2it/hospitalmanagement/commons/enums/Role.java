package com.ideas2it.hospitalmanagement.commons.enums;

public enum Role {

    NURSE("NURSE"), ADMIN("ADMIN"), RECEPTIONIST("RECEPTIONIST"), PHYSICIAN("PHYSICIAN");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static Role fromValue(int value) {
        for (Role role : values()) {  
            if (role.value.equals(value)) {  
                return role;  
            }  
        }  
        throw new IllegalArgumentException("Invalid role: " + value);  
    }

    public String toValue(){
        return value;
    }
}
