package com.ideas2it.hospitalmanagement.item.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.diagnosis.model.Diagnosis;
import java.util.Date;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.item.model.Item;;

/**
 * <p>
 * DiagnosisService is a Service-class used to provide logic to Diagnosis operations.
 * All the methods in this class throws Application Exception. Exceptions are
 * thrown if the input data is null.
 * Beans are injected during runtime using Spring IOC.
 * </p>
 *
 * @author    Hariharasudan K S
 * @version   1.0
 */
public interface ItemService {
	
	 /**
     * <p>
     * This Method is used to add a new diagnosis using the details provided by
     * the user. Returns true if the entry is added successfully, else returns
     * false.
     * </p>
     *
     * @param diagnosis an Diagnosis object containing all the details of the
     *                 diagnosis to be added.
     *
     * @return Boolean a boolean indicating the id of diagnosis that is added.
     *
     * @throws ApplicationException A Custom Exception created for catching
     *                              exceptions that occur while adding an
     *                              diagnosis.
     */
	public boolean createItem(Item item) throws ApplicationException;
	
	/**
     * <p>
     *  This Method is used to obtain all the diagnosis details using an
     *  list. Returns an empty list if no diagnosis are added.
     * </p>
     *
     * @return diagnosis a list consisting of all the diagnosis that are
     *                   added.
     *
     * @throws ApplicationException A Custom Exception created for catching
     *                              exceptions that occur while retrieving all
     *                              diagnosis.
     */
	public List<Item> retrieveAllItems() throws ApplicationException;
	
	/**
     * <p>
     *  This Method is used to modify the details of an existing diagnosis with
     *  updated details provided by the user. Returns true if the diagnosis 
     *  information is updated, else returns false if the operation fails.
     * </p>
     *
     * @param daignosis an Daignosis object is passed with the id of the old
     *                    Diagnosis which is used as a reference.
     *
     * @return boolean a boolean value is returned whether the operation to
     *                 modify is successful or not.
     *
     * @throws ApplicationException A Custom Exception created for catching
     *                              exceptions that occur while modifying an
     *                              diagnosis.
     */	
	public boolean modifyItem(Item item) throws ApplicationException;

	public Item retrieveItemById(int id) throws ApplicationException;
	
	
}
