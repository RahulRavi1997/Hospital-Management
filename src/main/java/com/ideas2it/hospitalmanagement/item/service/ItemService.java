package com.ideas2it.hospitalmanagement.item.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.item.model.Item;;

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
public interface ItemService {

	/**
	 * <p>
	 * This Method is used to add a new Item using the details provided by the
	 * physician. Returns true if the entry is added successfully, else returns
	 * false.
	 * </p>
	 *
	 * @param item
	 *            an Item object containing all the details of the item to be added.
	 * @return Boolean a boolean indicating the id of item that is added.
	 * @throws ApplicationException
	 *             A Custom Exception created for catching exceptions that occur
	 *             while adding an diagnosis.
	 */
	public boolean createItem(Item item) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to obtain all the item details using an list. Returns an
	 * empty list if no items are added.
	 * </p>
	 *
	 * @return Items a list consisting of all the items that are added.
	 * @throws ApplicationException
	 *             A Custom Exception created for catching exceptions that occur
	 *             while retrieving all diagnosis.
	 */
	public List<Item> retrieveAllItems() throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to modify the details of an existing item with updated
	 * details provided by the physician. Returns true if the diagnosis information
	 * is updated, else returns false if the operation fails.
	 * </p>
	 *
	 * @param item
	 *            an Item object is passed with the id of the old Diagnosis which is
	 *            used as a reference.
	 * @return boolean a boolean value is returned whether the operation to modify
	 *         is successful or not.
	 * @throws ApplicationException
	 *             A Custom Exception created for catching exceptions that occur
	 *             while modifying an Item.
	 */
	public boolean modifyItem(Item item) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve the details of an existing item with the help
	 * of its ID
	 * </p>
	 *
	 * @param id
	 *            ,the id of the Item object is passed
	 * @return Item object which matches the corresponding ID
	 * @throws ApplicationException
	 *             A Custom Exception created for catching exceptions that occur
	 *             while modifying an Item.
	 */
	public Item retrieveItemById(int id) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve the details of an existing item with the help
	 * of its name
	 * </p>
	 *
	 * @param name
	 *            ,the name of the Item object is passed
	 * @return List of all Item objects which matches the corresponding name
	 * @throws ApplicationException
	 *             A Custom Exception created for catching exceptions that occur
	 *             while modifying an Item.
	 */
	public List<String> retrieveItemByName(String name) throws ApplicationException;

}
