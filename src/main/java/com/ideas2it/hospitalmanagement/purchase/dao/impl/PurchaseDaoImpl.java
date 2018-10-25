package com.ideas2it.hospitalmanagement.purchase.dao.impl;

import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;

import org.springframework.transaction.annotation.Transactional;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.purchase.dao.PurchaseDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.medicine.model.Medicine;
import com.ideas2it.hospitalmanagement.purchase.model.Purchase;
import com.ideas2it.hospitalmanagement.purchaseDetails.model.PurchaseDetails;
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
            Logger.error(String.format
                (Constants.PURCHASE_ADDITION_EXCEPTION, purchase.getId()), e);
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
            Logger.error(String.format
                (Constants.PURCHASE_UPDATE_EXCEPTION, purchase.getId()), e);
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
            Logger.error(e);
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
            Logger.error(String.format
                (Constants.PURCHASE_SEARCH_EXCEPTION, purchaseId), e);
            throw new ApplicationException(String.format
                (Constants.PURCHASE_SEARCH_EXCEPTION, purchaseId), e);
        }
    }
    
    /**
	 *  {@inheritDoc}
	 */
	public boolean restorePurchase(Purchase purchase)
			throws ApplicationException {
		purchase.setActive(Boolean.TRUE);
		return updatePurchase(purchase);
	}

    /**
	 *  {@inheritDoc}
	 */
    public boolean updateMedicine(PurchaseDetails purchaseDetails, double quantity) throws ApplicationException {
        try {
			Session session = super.getSession();
            Transaction transaction;
			Query query = session.createQuery("update Medicine set quantity = :quantity" +
    			" where name = :name");
            double quant = quantity + purchaseDetails.getQuantity();
            query.setParameter("quantity", quant);
            query.setParameter("name", purchaseDetails.getMedicineName());
            transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            if (result == 1) {
                return true;
            } else {
                return false;
            }
        } catch (ApplicationException e) {
            Logger.error(Constants.MEDICINE_UPDATE_EXCEPTION, e);
			throw new ApplicationException(Constants.MEDICINE_UPDATE_EXCEPTION, e);
		}
	}
}
