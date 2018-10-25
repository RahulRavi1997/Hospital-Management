package com.ideas2it.hospitalmanagement.purchase.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.purchase.model.Purchase;
import com.ideas2it.hospitalmanagement.purchaseDetails.model.PurchaseDetails;

/**
 * <p>
 * This is a Service-Layer interface used to provide functionality classes for 
 * to implement data manipulation operations and business logic on purchase data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface PurchaseService {

    /**
     * <p>
     * This method is used to validate and return the status
     * of purchase addition to the database.
     * </p>
     *
     * @return purchaseDetails returns true if the details of purchase
     * is added.
     */ 
    public boolean addPurchase(Purchase purchase) throws ApplicationException;

    /**
     * <p>
     * This method is used to return the list of purchase
     * details from the database.
     * </p>
     *
     * @return purchaseDetails returns purchaseDetails.
     */
    public List<Purchase> retrievePurchases() throws ApplicationException;
    
    /**
     * <p>
     * This method is used to delete the purchase 
     * details from the list.
     * </p>
     *
     * @param purchaseId Id of the purchase.
     *
     * @return boolean either true or false.
     */
    public boolean deletePurchase(Purchase purchase) throws ApplicationException;
     
    /**
     * <p>
     * This method is used to update the purchase
     * details in the database.
     * </p>
     *
     * @return true if purchase is updated.
     */ 
    public boolean updatePurchase(Purchase purchase) throws ApplicationException;

    /**
     * <p>
     * This method is used to search the purchase Id
     * and return its details from the database.
     * </p>
     *
     * @param purchaseId Id of the purchase.
     *
     * @return Purchase purchase details.
     */
    public Purchase searchPurchase(int purchaseId) throws ApplicationException;
    
    /**
     * <p>
     * This method is used to restore the purchase 
     * and return its details from the database.
     * </p>
     *
     * @param purchaseId Id of the purchase.
     *
     * @return Purchase purchase details.
     */
   	public boolean restorePurchase(int id) throws ApplicationException;

    /**
     * <p>
     * This method is used to update the medicines to the master medicine
     * details in the database.
     * </p>
     *
     * @return true if purchase is updated.
     */
    public boolean updateMedicine(PurchaseDetails purchaseDetails) throws ApplicationException;   

}
