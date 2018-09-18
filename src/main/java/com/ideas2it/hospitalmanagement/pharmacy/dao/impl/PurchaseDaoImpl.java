package com.ideas2it.hospitalmanagement.pharmacy.dao.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.pharmacy.dao.PurchaseDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.pharmacy.model.Purchase;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;

/**
 * <p>
 * This is a Data-Access-Object Class for executing data manipulation
 * operation on purchase data such as add, update, remove and search.
 * on purchase details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class PurchaseDaoImpl extends GenericDao implements PurchaseDao {

	public PurchaseDaoImpl() throws ApplicationException {
		super();
	}
	
    /**
     * {@inheritDoc}
     */
    public boolean insertPurchase(Purchase purchase) throws ApplicationException {
    	purchase.setActive(Boolean.TRUE);
        try {
			return (null != super.save(purchase));
        } catch (ApplicationException e) {
            throw new ApplicationException(String.format
                (Constants.PURCHASE_ADDITION_EXCEPTION, purchase.getId()), e);            
        }
    } 

    /**
     * {@inheritDoc}
     */
    public boolean updatePurchase(Purchase purchase) throws ApplicationException {
    	try {
			return super.update(purchase);
        } catch (ApplicationException e) {
            throw new ApplicationException(String.format
                (Constants.PURCHASE_UPDATE_EXCEPTION, purchase.getId()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deletePurchase(Purchase purchase) throws ApplicationException {
    	purchase.setActive(Boolean.FALSE);
		return updatePurchase(purchase);
    }

    /**
     * {@inheritDoc}
     */
    public List<Purchase> getAllPurchases() throws ApplicationException {
    	try {
			return super.getAll(Purchase.class);
        } catch (ApplicationException e) {
            throw new ApplicationException(e);
        } 
    }

    /**
     * @{inheritdoc}
     */
    public Purchase searchPurchase(int purchaseId) throws ApplicationException {
    	try {
			return super.get(Purchase.class, purchaseId);
        } catch (ApplicationException e) {
            throw new ApplicationException(String.format
                (Constants.PURCHASE_SEARCH_EXCEPTION, purchaseId), e);
        }
    }
}
