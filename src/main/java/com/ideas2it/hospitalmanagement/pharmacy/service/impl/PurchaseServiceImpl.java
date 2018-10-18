package com.ideas2it.hospitalmanagement.pharmacy.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.pharmacy.dao.PurchaseDao;
import com.ideas2it.hospitalmanagement.pharmacy.dao.impl.PurchaseDaoImpl;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.pharmacy.model.Purchase;
import com.ideas2it.hospitalmanagement.pharmacy.service.PurchaseService;

/**
 * <p>
 * This class is used to manipulate and perform business logic operations with 
 * the purchase details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class PurchaseServiceImpl implements PurchaseService {
	
	public PurchaseServiceImpl() throws ApplicationException {
		super();
	}
	
    private PurchaseDao purchaseDao = new PurchaseDaoImpl();
  
    /**
     * @{inheritdoc}
     */
    public boolean addPurchase(Purchase purchase) throws ApplicationException {
        return purchaseDao.insertPurchase(purchase);
    }

    /**
     * @{inheritdoc}
     */
    public List<Purchase> retrievePurchases() throws ApplicationException {
        return purchaseDao.getAllPurchases();
    }
    
    /**
     * @{inheritdoc}
     */
    public boolean deletePurchase(Purchase purchase) throws ApplicationException {
        return purchaseDao.deletePurchase(purchase);
    }

    /**
     * @{inheritdoc}
     */
    public boolean updatePurchase(Purchase purchase) throws ApplicationException {
        return purchaseDao.updatePurchase(purchase);
    }
    
    /**
     * @{inheritdoc}
     */
    public Purchase searchPurchase(int purchaseId) throws ApplicationException {
        return purchaseDao.searchPurchase(purchaseId);
    }
}
