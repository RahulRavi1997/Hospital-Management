package com.ideas2it.hospitalmanagement.pharmacy.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.pharmacy.dao.ItemDao;
import com.ideas2it.hospitalmanagement.pharmacy.dao.impl.ItemDaoImpl;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.pharmacy.model.Item;
import com.ideas2it.hospitalmanagement.pharmacy.service.ItemService;

/**
 * <p>
 * This class is used to manipulate and perform business logic operations with 
 * the Item details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class ItemServiceImpl implements ItemService {
	
	public ItemServiceImpl() throws ApplicationException {
		super();
	}
	
    private ItemDao itemDao = new ItemDaoImpl();
  
    /**
     * @{inheritdoc}
     */
    public boolean addItem(Item item) throws ApplicationException {
        return itemDao.insertItem(item);
    }

    /**
     * @{inheritdoc}
     */
    public List<Item> retrieveItems() throws ApplicationException {
        return itemDao.getAllItems();
    }
    
    /**
     * @{inheritdoc}
     */
    public boolean deleteItem(Item item) throws ApplicationException {
        return itemDao.deleteItem(item);
    }

    /**
     * @{inheritdoc}
     */
    public boolean updateItem(Item item) throws ApplicationException {
        return itemDao.updateItem(item);
    }
    
    /**
     * @{inheritdoc}
     */
    public Item searchItem(int itemId) throws ApplicationException {
        return itemDao.searchItem(itemId);
    }
}
