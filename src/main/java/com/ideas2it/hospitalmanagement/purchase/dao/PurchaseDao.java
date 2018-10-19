package com.ideas2it.hospitalmanagement.purchase.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.purchase.model.Purchase;
import com.ideas2it.hospitalmanagement.purchaseDetails.model.PurchaseDetails;

/**
 * <p>
 * This is a Data-Access-Object Interface for executing data manipulation
 * operation on Purchase data such as add, update, remove and search.
 * on Purchase details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface PurchaseDao { 
    
    /**
     * <p>
     * This method is used to add the Purchase
     * details to the list.
     * </p>
     *
     * @return boolean returns true if the details of Purchase
     * is added to the list.
     */
    public boolean insertPurchase(Purchase purchase) throws ApplicationException;

    /**
     * <p>
     * This method is used to return the Purchase
     * details from the list.
     * </p>
     *
     * @return Purchase returns PurchaseDetails.
     */ 
    public List<Purchase> getAllPurchases() throws ApplicationException;

    /**
     * <p>
     * This method is used to find the Purchase Id
     * and delete its details from the list.
     * </p>
     *
     * @param PurchaseId Id of the Purchase.
     *
     * @return boolean either true or false.
     */
    public boolean deletePurchase(Purchase purchase) throws ApplicationException;
    
    /**
     * <p>
     * This method is used to update the Purchase
     * details in the list.
     * </p>
     *
     * @return true if Purchase is updated.
     */ 
    public boolean updatePurchase(Purchase purchase) throws ApplicationException;

    /**
     * <p>
     * This method is used to search the particular Purchase
     * detail in the list.
     * </p> 
     *
     * @param PurchaseId int contains Id of the Purchase.
     *
     * @return Purchase details of the Purchase.
     */
    public Purchase searchPurchase(int purchaseId) throws ApplicationException;

	public boolean restorePurchase(Purchase purchase) throws ApplicationException;

    public boolean updateMedicine(PurchaseDetails purchaseDetails, double quantity) throws ApplicationException;
}
