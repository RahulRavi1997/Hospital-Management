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
     *  insertWard is a method which inserts a ward object inside the
     *  database.
     *  </p>
     *  
     *  @param ward                             Ward object
     *  
     *  @return boolean
     */
    public Ward insertWard(Ward ward) throws ApplicationException;
    
    /**
     *  <p>
     *  updateWard is a method which updates a ward object inside the
     *  database.
     *  </p>
     *  
     *  @param ward                             Ward object
     *  
     *  @return boolean
     */
    public boolean updateWard(Ward ward) throws ApplicationException;
    
    /**
     *  <p>
     *  searchWardByNumber is a method retrieves a ward object for a given
     *  ward number.
     *  </p>
     *  
     *  @param    wardNumber           ward number
     *  
     *  @return Ward                   Ward object
     */
    public Ward searchWard(int wardNumber) throws ApplicationException;

    
    
	/**
	 * <p>
	 * Delete a particular ward.
	 * </p>
	 * @param   ward  ward information
	 * @return  true  if the ward is deleted
	 *          false if the ward is not deleted.
	 * @throws ApplicationException
	 */
	public boolean deleteWard(Ward ward) throws ApplicationException;

	/**
	 * <p>
	 * display all the wards 
	 * </p>
	 * @param   status  Status of the ward to be searched.
	 * @return
	 * @throws ApplicationException
	 */
	public List<Ward> displayAllWards(String status) throws ApplicationException;

	public boolean changeWardToFree(Ward ward)throws ApplicationException;

	public boolean addRoomsToWard(Ward ward)throws ApplicationException;


}