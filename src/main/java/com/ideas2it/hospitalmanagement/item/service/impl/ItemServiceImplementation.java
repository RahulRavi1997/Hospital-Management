package com.ideas2it.hospitalmanagement.item.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.item.dao.ItemDao;
import com.ideas2it.hospitalmanagement.item.model.Item;
import com.ideas2it.hospitalmanagement.item.service.ItemService;

/**
 * <p>
 * ItemService is a Service-class used to provide logic to Item operations. All
 * the methods in this class throws Application Exception. Exceptions are thrown
 * if the input data is null. Beans are injected during runtime using Spring
 * IOC.
 * </p>
 *
 * @author Hariharasudan K S and navaneeth.
 */
@Service
public class ItemServiceImplementation implements ItemService {

	public static ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public ItemDao getItemDao() {
		return this.itemDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean createItem(Item item) throws ApplicationException {

		return itemDao.insertItem(item);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> retrieveItemByName(String name) throws ApplicationException {
		return itemDao.fetchAllItemsMaster(name);

	}

	/**
	 * {@inheritDoc}
	 */
	public Item retriveItemNameById(int id) throws ApplicationException {

		return itemDao.searchItemById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Item> retrieveAllItem() throws ApplicationException {
		return itemDao.fetchAllItems();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean modifyItemById(Item item) throws ApplicationException {
		if (item == null) {
			throw new ApplicationException(Constants.ID_NOT_NULL);
		}
		return itemDao.updateItem(item);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Item> retrieveAllItems() throws ApplicationException {
		return itemDao.fetchAllItems();

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean modifyItem(Item item) throws ApplicationException {
		if (null == item) {
			throw new ApplicationException(Constants.ID_NOT_NULL);
		}
		return itemDao.updateItem(item);
	}

	/**
	 * {@inheritDoc}
	 */
	public Item retrieveItemById(int id) throws ApplicationException {
		return itemDao.searchItemById(id);
	}

}
