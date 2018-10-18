package com.ideas2it.hospitalmanagement.pharmacy.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.pharmacy.model.Item;

/**
 * <p>
 * This is a Service-Layer interface used to provide functionality classes  
 * to implement data manipulation operations and business logic on item data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface ItemService {

    /**
     * <p>
     * This method is used to validate and return the status
     * of item addition to the database.
     * </p>
     *
     * @return itemDetails returns true if the details of item
     * is added.
     */ 
    public boolean addItem(Item item) throws ApplicationException;

    /**
     * <p>
     * This method is used to return the list of item
     * details from the database.
     * </p>
     *
     * @return itemDetails returns ItemDetails.
     */
    public List<Item> retrieveItems() throws ApplicationException;
    
    /**
     * <p>
     * This method is used to delete the item 
     * details from the list.
     * </p>
     *
     * @param itemId Id of the item.
     *
     * @return boolean either true or false.
     */
    public boolean deleteItem(Item item) throws ApplicationException;
     
    /**
     * <p>
     * This method is used to update the item
     * details in the database.
     * </p>
     *
     * @return true if item is updated.
     */ 
    public boolean updateItem(Item item) throws ApplicationException;

    /**
     * <p>
     * This method is used to search the item Id
     * and return its details from the database.
     * </p>
     *
     * @param itemId Id of the item.
     *
     * @return Item item details.
     */
    public Item searchItem(int itemId) throws ApplicationException;
  
}
