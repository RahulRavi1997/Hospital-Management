package com.ideas2it.hospitalmanagement.pharmacy.model;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of items.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class Item {
    private int id;
    private String name;
    private Double quantity;
    private Double amount;    
    private boolean active; 

    public Item() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
   
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
} 
