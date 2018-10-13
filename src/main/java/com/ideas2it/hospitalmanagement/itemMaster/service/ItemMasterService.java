package com.ideas2it.hospitalmanagement.itemMaster.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.diagnosis.model.Diagnosis;
import java.util.Date;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.item.model.Item;
import com.ideas2it.hospitalmanagement.itemMaster.model.ItemMaster;

/**
 * <p>
 * ItemMaster is a Service-class used to provide logic to Item Master
 * operations. All the methods in this class throws Application Exception.
 * Exceptions are thrown if the input data is null. Beans are injected during
 * runtime using Spring IOC.
 * </p>
 *
 * @author Hariharasudan K S
 * @version 1.0
 */
public interface ItemMasterService {

	/**
	 * <p>
	 * This Method is used to list out all the available items in the Master Table
	 * </p>
	 *
	 * @param name
	 *            the name of the item to be matched in master table
	 * @return List of Itemmaster objects containing Item ID and Item name
	 * @throws ApplicationException
	 *             A Custom Exception created for catching exceptions that occur
	 *             while adding an diagnosis.
	 */
	public List<ItemMaster> retrieveItemByName(String name) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to create a new medicine Item into Master table
	 * </p>
	 * 
	 * @param ItemMaster
	 *            object to be created
	 * @return boolean if the creation is successful or not
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */
	public boolean createItem(ItemMaster item) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to mpdify an existing new medicine Item present in the
	 * master table
	 * </p>
	 *
	 * @return boolean if the updation is successful or not
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */

	public boolean modifyItem(ItemMaster item) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve an item from master table with its ID
	 * </p>
	 *
	 * @return ItemMaster object
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */

	public ItemMaster retrieveItemByName(int id) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve all items from the master table
	 * </p>
	 *
	 * @return a List of all ItemMaster objects
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             fetching all diagnosis.
	 */
    public List<ItemMaster> retrieveAllItems() throws ApplicationException;

}
