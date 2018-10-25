package com.ideas2it.hospitalmanagement.medicine.model;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of medicines.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class Medicine {
    private int id;
    private String name;
    private double quantity;
    private Double amount;    
    private boolean active; 

    public Medicine() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
   
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return this.active;
    }
} 
