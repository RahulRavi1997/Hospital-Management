package com.ideas2it.hospitalmanagement.pharmacy.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.pharmacy.model.Item;

/**
 * <p>
 * This is a Data-Access-Object Interface for executing data manipulation
 * operation on Item data such as add, update, remove and search.
 * on Item details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface ItemDao { 
    
    /**
     * <p>
     * This method is used to add the Item
     * details to the list.
     * </p>
     *
     * @return boolean returns true if the details of Item
     * is added to the list.
     */
    public boolean insertItem(Item item) throws ApplicationException;

    /**
     * <p>
     * This method is used to return the item
     * details from the list.
     * </p>
     *
     * @return Item returns itemDetails.
     */ 
    public List<Item> getAllItems() throws ApplicationException;

    /**
     * <p>
     * This method is used to find the Item Id
     * and delete its details from the list.
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
     * details in the list.
     * </p>
     *
     * @return true if item is updated.
     */ 
    public boolean updateItem(Item item) throws ApplicationException;

    /**
     * <p>
     * This method is used to search the particular item
     * detail in the list.
     * </p> 
     *
     * @param itemId int contains Id of the item.
     *
     * @return Item details of the item.
     */
    public Item searchItem(int itemId) throws ApplicationException;

}
