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
public class PurchaseDetails {
    private int id;
    private String itemName;
    private Double quantity;
    private boolean active;
    private int purchaseId;

    public PurchaseDetails() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
 
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public String getItemName() {
        return itemName;
    }
   
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }
} 
