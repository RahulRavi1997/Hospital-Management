package com.ideas2it.hospitalmanagement.physician.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.physician.model.Physician;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

public interface PhysicianDao {
	
	    /**
	     * <p>
	     * This Method is used to add the physician details given by the user and
	     * adds them to the Database. It returns true if the entry is added
	     * successfully, else returns false.
	     * </p>
	     *
	     * @param physician an Physician object consisting of the details of the
	     *                 new physician provided by the user.
	     *                 
	     * @return Boolean a boolean indicating the id of the Physician that is inserted.
	     *
	     * @throws ApplicationException An exception created for catching exceptions
	     *                              that occur while adding an physician.
	     */
	    public Boolean insertPhysician(Physician physician) throws ApplicationException;

	    /**
	     * <p>
	     *  This Method is used to update the details of an Physician. Returns true
	     *  if the entry is modified, else returns false.
	     *  <p>
	     *
	     * @param physician an Physician object is passed with the details to be
	     *                 updated.
	     *
	     * @return boolean a boolean value is returned whether the operation is
	     *                 successful or not.
	     *
	     * @throws ApplicationException An exception created for catching exceptions
	     *                              that occur while updating an physician.
	     */
	    public boolean updatePhysician(Physician physician) throws ApplicationException;

	    /**
	     * <p>
	     * This Method is used to delete an Physician. Returns true if the entry is
	     * removed, else returns false.
	     * </p>
	     *
	     * @param physician an Physician object that is to be deleted from the
	     *                 database table.
	     *
	     * @return boolean a boolean value is returned whether the operation to
	     *                 remove is successful or not.
	     *
	     * @throws ApplicationException An exception created for catching exceptions
	     *                              that occur while deleting an physician.
	     */
	    public boolean deletePhysician(Physician physician) throws ApplicationException;

	    /**
	     * <p>
	     * This Method is used to search for an physician. Returns the physician
	     * object if a match is found with same id, else returns null.
	     * </p>
	     *
	     * @param id         an Integer to identify the required Physician
	     *                   Object by the ID of Physician.
	     *
	     * @return physician  an Physician object which has same id is returned.
	     *
	     * @throws ApplicationException An exception created for catching exceptions
	     *                              that occur while searching an physician.
	     */
	    public Physician searchPhysicianById(Integer id) throws ApplicationException;

	    /**
	     * <p>
	     *  This Method is used to re-activate an physician who has been deleted.
	     *  Returns true if the operation is successful.
	     * </p>
	     *
	     * @param physician an Physician object to be restored.
	     *
	     * @return boolean a boolean value is returned whether the operation to
	     *                 modify is successful or not.
	     *
	     * @throws ApplicationException A Custom Exception created for catching
	     *                              exceptions that occur while modifying an
	     *                              physician.
	     */
	    public boolean restorePhysician(Physician physician) throws ApplicationException;

	    /**
	     * <p>
	     * This Method is used to obtain an arraylist of all the physicians that
	     * are currently present.
	     * </p>
	     *
	     * @return physicians an Arraylist consisting of all the physicians is
	     *                   returned.
	     *
	     * @throws ApplicationException An exception created for catching exceptions
	     *                              that occur while displaying all physicians.
	     */
	    public List<Physician> getAllPhysicians() throws ApplicationException;

	    /**
	     * <p>
	     * This Method is used to obtain an arraylist of all selected physicians.
	     * </p>
	     *
	     * @return ids an Array of integers containing the id of physicians that are
	     *             to be retrieved.
	     *
	     * @throws ApplicationException An exception created for catching exceptions
	     *                              that occur while displaying all physicians.
	     */
	    public List<Physician> getPhysiciansByIds(Integer[] ids) throws ApplicationException;
	
	
}
