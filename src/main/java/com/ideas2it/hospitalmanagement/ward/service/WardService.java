package com.ideas2it.hospitalmanagement.ward.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.ward.model.Ward;


/**
 * WardService is the Service interface which is having the several data manipulation methods and
 * this class does the business logic operations on the ward related Details.
 * <p>
 * It has the Implementation class which is performing the business logic operations on the ward
 * Details.
 * </p>
 *
 * @author latheesh
 * @version 1.0
 */
public interface WardService {
	
	/**
	 * <p>
	 * Create a new ward with all the basic information.
	 * </p>
	 * @param   ward           ward information
	 * 	 
	 * @return  ward           ward information after creation
	 * 
	 * @throws ApplicationException
	 */
	public Ward createWard(Ward ward) throws ApplicationException;
	
	/**
	 * <p>
	 * Update a ward with all the necessary information.
	 * </p>
	 * @param   ward  ward information 
	 * 
	 * @return  true  if the ward is updated
	 *          false if the ward is not updated.
	 *         
	 * @throws ApplicationException
	 */
	public boolean updateWard(Ward ward) throws ApplicationException;
	
	/**
	 * <p>
	 * Search a particular ward with the help of the ward number.
	 * </p>
	 * @param     wardNumber    ward Number
	 * 
	 * @return    ward          ward information of the particular ward number
	 * 
	 * @throws ApplicationException
	 */
	public Ward searchWard(Integer wardNumber) throws ApplicationException;
	
	/**
	 * <p>
	 * Delete a particular ward.
	 * </p>
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
	 * display all the wards 
	 * </p>
	 * @param  status   status of the Ward to be searched.
	 * @return
	 * @throws ApplicationException
	 */
	public List<Ward> displayAllWards(String status) throws ApplicationException;
	
	/**
	 * Change the ward status to free after maintaince.
	 * 
	 * @param ward             Ward Information
	 *  
	 * @return  true           if the ward status is changed
	 *          false          if the ward status is  not changed
	 *          
	 * @throws ApplicationException
	 */
	public boolean changeWardToFree(Ward ward) throws ApplicationException;
	

	/**
	 * Add rooms to an existing ward with the specified number.
	 * 
	 * @param ward             Ward Information
	 * 
	 * @param   numberOfRooms  Number of rooms to be in a ward. 
	 * 
	 * @return  true           if the rooms are added to ward
	 *          false          if the rooms are not added to ward
	 *          
	 * @throws ApplicationException
	 */
    public boolean addRoomsToWard(Ward ward, int numberOfRooms) throws ApplicationException;

    /**
     * Display all the visits with the specified status.
     * 
     * @param     string  status of the visit to be searched
     * 
     * @return            list of viists with the specified status
     * 
     * @throws ApplicationException
     */
	public List<Visit> getVisitsByPatientType(String status) throws ApplicationException;
	
	
	
	
}