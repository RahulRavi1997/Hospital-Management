package com.ideas2it.hospitalmanagement.itemMaster.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.itemMaster.model.ItemMaster;

public interface ItemMasterDao {

	/**
	 * <p>
	 * This Method is used to obtain the list of of all the Items that are currently
	 * present in the master table
	 * </p>
	 *
	 * @return ItemMaster list consisting of all the Medicine Items for a specific
	 *         date is returned.
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */
	public List<ItemMaster> fetchItemsByName(String name) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to insert a new medicine Item into Master table
	 * </p>
	 *
	 * @return boolean if the insertion is successful or not
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */

	public boolean insertItem(ItemMaster item) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to update an existing new medicine Item into Master table
	 * </p>
	 *
	 * @return boolean if the updation is successful or not
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */

	public boolean updateItem(ItemMaster item) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to search an item from master table with its ID
	 * </p>
	 *
	 * @return ItemMaster object
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */

	public ItemMaster searchItemById(int id) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to display all items from the master table
	 * </p>
	 *
	 * @return a List of all ItemMaster objects
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */

	public List<ItemMaster> fetchAllItems() throws ApplicationException;

}
