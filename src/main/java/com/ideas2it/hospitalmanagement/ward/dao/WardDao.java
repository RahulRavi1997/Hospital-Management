package com.ideas2it.hospitalmanagement.ward.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * <p>
 * WardDAO is an interface which holds methods for creation,updation and retrieval of wards.
 * </p>
 * @author Latheesh
 *
 */
public interface WardDao {
    
    /**
     *  <p>
     *  InsertWard is a method which inserts a ward object inside the
     *  database.
     *  </p>
     *  
     * @param   ward   Ward object
     *  
	 * @return   true   if the ward is inserted
	 *           false  if the ward is not inserted.
	 *           
	 * @throws ApplicationException

     *  @return boolean
     */
    public Ward insertWard(Ward ward) throws ApplicationException;
    
    /**
     *  <p>
     *  UpdateWard is a method which updates a ward object inside the
     *  database.
     *  </p>
     *  
     * @param   ward   Ward object
     *  
	 * @return   true   if the ward is updated
	 *           false  if the ward is not updated.
	 *           
	 * @throws ApplicationException
     */
    public boolean updateWard(Ward ward) throws ApplicationException;
    
    /**
     *  <p>
     *  searchWardByNumber is a method retrieves a ward object for a given
     *  ward number.
     *  </p>
     *  
     * @param    wardNumber   number to be searched
     *  
     *  @return  Ward         Ward object
     *  
	 * @throws ApplicationException
     */
    public Ward searchWard(int wardNumber) throws ApplicationException;

    
	/**
	 * <p>
	 * Make the ward status to under maintaince.
	 * </p>
	 * 
	 * @param   ward  ward information
	 * 
	 * @return  true  if the ward is deleted
	 *          false if the ward is not deleted.
	 *          
	 * @throws ApplicationException
	 */
	public boolean deleteWard(Ward ward) throws ApplicationException;

	/**
	 * <p>
	 * display all the wards with the particular status
	 * </p>
	 * 
	 * @param   status  Status of the ward to be searched.
	 * 
	 * @return          List of all wards with the specified
	 *                  status.
	 *                  
	 * @throws ApplicationException
	 */
	public List<Ward> displayAllWards(String status) throws ApplicationException;

	/**
	 * <p>
	 * Change the ward to free if it is under maintaince 
	 * </p>
	 * @param   ward  ward information
	 * 
	 * @return  true  if the ward status is changed
	 *          false if the ward status is not changed.
	 *          
	 * @throws ApplicationException
	 */
	public boolean changeWardToFree(Ward ward)throws ApplicationException;

	/**
	 * <p>
	 * Add Rooms to the existing ward.
	 * </p>
	 * @param   ward  ward information
	 * 
	 * @return  true  if the rooms are added
	 *          false if the rooms are not added.
	 *          
	 * @throws ApplicationException
	 */
	public boolean addRoomsToWard(Ward ward)throws ApplicationException;
}