package com.ideas2it.hospitalmanagement.purchase.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.purchase.dao.PurchaseDao;
import com.ideas2it.hospitalmanagement.purchase.dao.impl.PurchaseDaoImpl;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.medicine.model.Medicine;
import com.ideas2it.hospitalmanagement.purchase.model.Purchase;
import com.ideas2it.hospitalmanagement.purchaseDetails.model.PurchaseDetails;
import com.ideas2it.hospitalmanagement.purchase.service.PurchaseService;
import com.ideas2it.hospitalmanagement.medicine.service.MedicineService;
import com.ideas2it.hospitalmanagement.medicine.service.impl.MedicineServiceImpl;

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
    private MedicineService medicineService = new MedicineServiceImpl();
  
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
    
    /**
   	 *  {@inheritDoc}
   	 */
   	public boolean restorePurchase(int id) throws ApplicationException {
   		Purchase purchase = searchPurchase(id);
   		if(null == purchase) {
   			return Boolean.FALSE;
   		}
   		return purchaseDao.restorePurchase(purchase);
   	}

    /**
   	 *  {@inheritDoc}
   	 */
    public boolean updateMedicine(PurchaseDetails purchaseDetails) throws ApplicationException {
        double quantity = 0;
        String name = purchaseDetails.getMedicineName();
        List<Medicine> medicines = medicineService.retrieveMedicinesByName(name);
        for (Medicine medicine : medicines) {
            quantity = medicine.getQuantity();
        }
        return purchaseDao.updateMedicine(purchaseDetails, quantity);
    }   
}
