package com.ideas2it.hospitalmanagement.prescription.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

/**
 * PrescriptionDao is the DAO interface program which is having the methods that
 * is processing the data access operations of the Prescription Details.
 * <p>
 * It is having the implementation classes, which performs the Add,Modify,
 * Remove,Search and Display the prescription details.
 * </p>
 * This interface has a method to gather details of all the prescriptions that
 * are stored in the Database.
 *
 * @author navaneeth and hari.
 */
public interface PrescriptionDao {

	/**
	 * <p>
	 * This Method is used to add the prescription details given by the physician
	 * and adds them to the Database. It returns true if the entry is added
	 * successfully, else returns false.
	 * </p>
	 *
	 * @param prescription a prescription object consisting of the details of the
	 *                     new diagnosis provided by the physician.
	 * @return int the id of the Prescription that is inserted.
	 * @throws ApplicationException An exception created for catching exceptions
	 *                              that occur while adding an Prescription.
	 */
	public int insertPrescription(Prescription prescription) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to update the details of an Prescription. Returns true if
	 * the entry is modified, else returns false.
	 * <p>
	 *
	 * @param Prescription an Prescription object is passed with the details to be
	 *                     updated.
	 * @return boolean a boolean value is returned whether the operation is
	 *         successful or not.
	 * @throws ApplicationException An exception created for catching exceptions
	 *                              that occur while updating an Dosage.
	 */
	public boolean updatePrescription(Prescription prescription) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve all prescriptions by visitID
	 * 
	 * @param visitID id of patient whose prescription is to be searched
	 * @return List of Prescription objects which matches the string passed
	 * @throws ApplicationException An exception created for catching exceptions
	 *                              that occur while searching an Prescription.
	 */
	public List<Prescription> retrivePrescriptionsByVisitId(int visitId) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve prescriptions by prescriptionID
	 * 
	 * @param ,prescriptionID id of patient whose prescription is to be searched
	 * @return prescription Prescription objects which matches the id.
	 * @throws ApplicationException An exception created for catching exceptions
	 *                              that occur while searching an Prescription.
	 */
	public Prescription searchPrescription(int prescriptionId) throws ApplicationException;
}