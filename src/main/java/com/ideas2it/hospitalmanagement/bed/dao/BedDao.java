package com.ideas2it.hospitalmanagement.bed.dao;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

/**
 * BedDao is the DAO interface program which is having the methods that is
 * processing the data access operations of the bed Details.
 * <p>
 * It is having the implementation classes, which performs the Add,Modify,
 * Remove,Search and Display the bed allocation details.
 * </p>
 * This interface has a method to gather details of all the bed and its related
 * details that are stored in the Database.
 *
 * @author latheesh
 * @version 1.0
 */

public interface BedDao {

	/**
	 * <p>
	 * searchBedByNumber method is used to retrieve the bed for a given bed number
	 * </p>
	 * 
	 * @param bedNumber Bed Number to be searched
	 * 
	 * @return Bed Bed object of the corresponding bed number
	 * 
	 */
	public Bed searchBedByNumber(int bedNumber) throws ApplicationException;

	/**
	 * <p>
	 * updateBed method is used to update the modified bed in the database.
	 * </p>
	 * 
	 * @param Bed Bed object to be updated
	 * 
	 * @return boolean Indicates whether the bed is updated or not
	 */
	public boolean updateBed(Bed bed) throws ApplicationException;

	/**
	 * <p>
	 * searchBedByVisit method is used to search a specific bed associated with a
	 * visit
	 * </p>
	 * 
	 * @param Bed Bed object
	 * 
	 * @return boolean Indicates whether the bed is updated or not
	 */

	public Bed searchBedByVisit(Visit visit) throws ApplicationException;

}