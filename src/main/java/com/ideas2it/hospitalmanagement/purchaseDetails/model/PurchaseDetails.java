package com.ideas2it.hospitalmanagement.purchaseDetails.model;

import com.ideas2it.hospitalmanagement.purchase.model.Purchase;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of medicines.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class PurchaseDetails {
    private int id;
    private String medicineName;
    private double quantity;
    private boolean active;
    private Purchase purchase;

    public PurchaseDetails() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
 
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
    
    public String getMedicineName() {
        return medicineName;
    }
   
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }
} 
