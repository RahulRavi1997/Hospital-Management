package com.ideas2it.hospitalmanagement.itemMaster.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.itemMaster.dao.ItemMasterDao;
import com.ideas2it.hospitalmanagement.itemMaster.model.ItemMaster;
import com.ideas2it.hospitalmanagement.item.model.Item;
import com.ideas2it.hospitalmanagement.itemMaster.service.ItemMasterService;

/**
 * <p>
 * ItemServiceImplementation is a Service-class used to provide logic to Diagnosis operations.
 * All the methods in this class throws Application Exception. Exceptions are thrown if the input
 * data is null. Beans are injected during runtime using Spring IOC.
 * </p>
 *
 * @author Hariharasudan K S and navaneeth.
 */
@Service
public class ItemMasterServiceImplementation implements ItemMasterService {

    public static ItemMasterDao itemMasterDao;

    public void setItemMasterDao(ItemMasterDao itemMasterDao) {
        this.itemMasterDao = itemMasterDao;
    }

    public ItemMasterDao getItemMasterDao() {
        return this.itemMasterDao;
    }

    /**
     * {@inheritDoc}
     */
    public boolean createItem(ItemMaster item) throws ApplicationException {
        return itemMasterDao.insertItem(item);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyItem(ItemMaster item) throws ApplicationException {
        return itemMasterDao.updateItem(item);
    }

    /**
     * {@inheritDoc}
     */
    public List<ItemMaster> retrieveItemByName(String name) throws ApplicationException {

        return itemMasterDao.fetchItemsByName(name);
    }

    /**
     * {@inheritDoc}
     */
    public ItemMaster retrieveItemByName(int id) throws ApplicationException {
        return itemMasterDao.searchItemById(id);
    }

    /**
     * {@inheritDoc}
     */
    public List<ItemMaster> retrieveAllItems() throws ApplicationException {
        return itemMasterDao.fetchAllItems();
    }
}
