package com.ideas2it.hospitalmanagement.item.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.item.dao.ItemDao;
import com.ideas2it.hospitalmanagement.item.model.Item;
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
 * @author Hariharasudan K S and navaneeth
 * @version 1.0
 */
public class ItemDaoImplementation extends GenericDao implements ItemDao {

	public static final String ITEM_IN_QUERY = "from Item where id in (:ids)";
	public static final String IDS = "ids";
    public static final String ITEMS_IN_NAMES = "from Item where itemName like :name";
	public static final String NAMES = "name";

	public ItemDaoImplementation() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean insertItem(Item item) throws ApplicationException {
		try {
			return (null != super.save(item));
		} catch (ApplicationException e) {
			Logger.error(Constants.ITEM_ADDITION_EXCEPTION, e);
			throw new ApplicationException(String.format(Constants.DIAGNOSIS_ADDITION_EXCEPTION, item.getId()));
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Item> fetchAllItems() throws ApplicationException {
		try {
			return super.getAll(Item.class);
		} catch (ApplicationException e) {
			Logger.error(Constants.ITEM_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.ITEM_DISPLAY_EXCEPTION);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> fetchAllItemsMaster(String name) throws ApplicationException {
		try {
			Session session = super.getSession();
			Query query = session.createQuery(ITEMS_IN_NAMES);
			query.setParameter(NAMES, name + "%");
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(Constants.ITEM_DISPLAY_EXCEPTION+name, e);
			throw new ApplicationException(Constants.ITEM_DISPLAY_EXCEPTION);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Item> fetchItemByName(String name) throws ApplicationException {
		try {
			Session session = super.getSession();
			Query query = session.createQuery(ITEMS_IN_NAMES);
			query.setParameter(NAMES, name + "%");
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(Constants.ITEM_DISPLAY_EXCEPTION+name, e);
			throw new ApplicationException(Constants.ITEM_DISPLAY_EXCEPTION);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateItem(Item item) throws ApplicationException {
		try {
			return super.update(item);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.ITEM_EDIT_EXCEPTION, item.getId()), e);
			throw new ApplicationException(String.format(Constants.ITEM_EDIT_EXCEPTION, item.getId()));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Item searchItemById(int id) throws ApplicationException {
		try {
			return super.get(Item.class, id);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.ITEM_SEARCH_EXCEPTION, id), e);
			throw new ApplicationException(String.format(Constants.ITEM_SEARCH_EXCEPTION, id));
		}
	}
}
