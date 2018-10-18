package com.ideas2it.hospitalmanagement.dosage.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * Dosage is the DAO interface program which is having the methods that is
 * processing the data access operations of the Dosage Details.
 * <p>
 * It is having the implementation classes, which performs the Add,Modify,
 * Remove,Search and Display the dosage details.
 * </p>
 * This interface has a method to gather details of all the dosages that are
 * stored in the Database.
 *
 * @author navaneeth and hari.
 */
public interface DosageDao {
	/**
	 * <p>
	 * This Method is used to add the dosage details given by the physician and adds
	 * them to the Database. It returns true if the entry is added successfully,
	 * else returns false.
	 * </p>
	 *
	 * @param Dosage
	 *            a Dosage object consisting of the details of the new diagnosis
	 *            provided by the user.
	 * 
	 * @return int the id of the Diagnosis that is inserted.
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             adding an diagnosis.
	 */
	public int insertDosage(Dosage dosage) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to update the details of an Dosage. Returns true if the
	 * entry is modified, else returns false.
	 * <p>
	 *
	 * @param dosage
	 *            an Dosage object is passed with the details to be updated.
	 *
	 * @return boolean a boolean value is returned whether the operation is
	 *         successful or not.
	 *
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             updating an Dosage.
	 */

	public boolean updateDosage(Dosage dosage) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to search for a particular dosage
	 * <p>
	 *
	 * @param id,
	 *            the ID of the dosage to be searched
	 *
	 * @return dosage a Dosage object which matches the id passed
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             searching an Dosage.
	 */

	public Dosage searchDosage(int dosageId) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve all dosage which matches the name for AJAX
	 * call purposes
	 * <p>
	 *
	 * @param ,
	 *            dosageName the name of the dosage to be searched
	 *
	 * @return List of Dosage objects which matches the string passed
	 * @throws ApplicationException
	 *             An exception created for catching exceptions that occur while
	 *             searching an Dosage.
	 */
	public List<Dosage> retrieveDosages(String dosageName) throws ApplicationException;
}