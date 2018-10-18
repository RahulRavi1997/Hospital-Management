package com.ideas2it.hospitalmanagement.purchase.model;

import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import com.ideas2it.hospitalmanagement.purchaseDetails.model.PurchaseDetails;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of purchases.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class Purchase {
    private int id;
    private String dealerName;
    private Date dateOfPurchase;
    private boolean active;
    private List<PurchaseDetails> listOfMedicines = new ArrayList<PurchaseDetails>();

    public Purchase() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
 
    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
    
    public String getDealerName() {
        return dealerName;
    }
   
    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    
    public void setListOfMedicines(List<PurchaseDetails> listOfMedicines) {
    	this.listOfMedicines = listOfMedicines;
    }
    
    public List<PurchaseDetails> getListOfMedicines() {
    	return listOfMedicines;
    }
    
} 
