package com.ideas2it.hospitalmanagement.pharmacy.dao.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.pharmacy.dao.ItemDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.pharmacy.model.Item;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;

/**
 * <p>
 * This is a Data-Access-Object Class for executing data manipulation
 * operation on Item data such as add, update, remove and search.
 * on Item details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class ItemDaoImpl extends GenericDao implements ItemDao {

	
	public ItemDaoImpl() throws ApplicationException {
		super();
	}
	
    /**
     * {@inheritDoc}
     */
    public boolean insertItem(Item item) throws ApplicationException {
		item.setActive(Boolean.TRUE);
        try {
			return (null != super.save(item));
        } catch (ApplicationException e) {
            throw new ApplicationException(String.format
                (Constants.ITEM_ADDITION_EXCEPTION, item.getId()), e);            
        }
    } 

    /**
     * {@inheritDoc}
     */
    public boolean updateItem(Item item) throws ApplicationException {      
        try {
			return super.update(item);
        } catch (ApplicationException e) {
            throw new ApplicationException(String.format
                (Constants.ITEM_UPDATE_EXCEPTION, item.getId()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteItem(Item item) throws ApplicationException {
    	item.setActive(Boolean.FALSE);
		return updateItem(item);
    }

    /**
     * {@inheritDoc}
     */
    public List<Item> getAllItems() throws ApplicationException {
        try {
			return super.getAll(Item.class);
        } catch (ApplicationException e) {
            throw new ApplicationException(e);
        } 
    }

    /**
     * @{inheritdoc}
     */
    public Item searchItem(int itemId) throws ApplicationException {      
        try {
			return super.get(Item.class, itemId);
        } catch (ApplicationException e) {
            throw new ApplicationException(String.format
                (Constants.ITEM_SEARCH_EXCEPTION, itemId), e);
        }
    }
}
