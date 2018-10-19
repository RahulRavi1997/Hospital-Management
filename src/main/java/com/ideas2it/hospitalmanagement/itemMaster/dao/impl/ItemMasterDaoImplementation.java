package com.ideas2it.hospitalmanagement.itemMaster.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.itemMaster.dao.ItemMasterDao;
import com.ideas2it.hospitalmanagement.itemMaster.model.ItemMaster;
import com.ideas2it.hospitalmanagement.logger.Logger;

/**
 * <p>
 * DiagnosisDaoImplementation is a Data-Access-Object Class for executing data
 * manipulation operation on diagnosis data such as add, update, display
 * <p>
 * All the methods in this class throws Application Exception- a custom
 * exception wrapping any exceptions thrown by Hibernate. Soft-delete is done
 * while deleting an employee, setting the status as inactive.
 * </p>
 * 
 * @author Hariharasudan K S
 * @version 1.0
 */

public class ItemMasterDaoImplementation extends GenericDao implements ItemMasterDao {

	public static final String ITEMS_IN_NAMES = "from ItemMaster where itemName like :name";
	public static final String NAMES = "name";
    public static final String ITEMS_IN_LIST = "from ItemMaster";

	public ItemMasterDaoImplementation() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ItemMaster> fetchItemsByName(String name) throws ApplicationException {
		try {
			Session session = super.getSession();
			Query query = session.createQuery(ITEMS_IN_NAMES);
			query.setParameter(NAMES, name + "%");
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(Constants.DIAGNOSIS_DISPLAY_EXCEPTION+name, e);
			throw new ApplicationException(Constants.DIAGNOSIS_DISPLAY_EXCEPTION, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean insertItem(ItemMaster item) throws ApplicationException {
		try {
			return (null != super.save(item));
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.ITEM_ADDITION_EXCEPTION, item.getId()), e);
			throw new ApplicationException(String.format(Constants.DIAGNOSIS_ADDITION_EXCEPTION, item.getId()), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateItem(ItemMaster item) throws ApplicationException {
		try {
			return super.update(item);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.ITEM_EDIT_EXCEPTION, item.getId()), e);
			throw new ApplicationException(String.format(Constants.ITEM_EDIT_EXCEPTION, item.getId()), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ItemMaster searchItemById(int id) throws ApplicationException {
		try {
			return super.get(ItemMaster.class, id);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.ITEM_SEARCH_EXCEPTION, id), e);
			throw new ApplicationException(String.format(Constants.ITEM_SEARCH_EXCEPTION, id));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ItemMaster> fetchAllItems() throws ApplicationException {
		try {
			return super.getAll(ItemMaster.class);
		} catch (ApplicationException e) {
			Logger.error(Constants.ITEM_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.ITEM_DISPLAY_EXCEPTION, e);
		}
    }
}
