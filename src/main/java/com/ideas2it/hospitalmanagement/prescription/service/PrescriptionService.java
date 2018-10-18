package com.ideas2it.hospitalmanagement.prescription.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.itemMaster.model.ItemMaster;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

/**
 * PrescriptionService is the Service interface which is having the several data
 * manipulation Prescription methods and this class does the business logic
 * operations on the Details.
 * <p>
 * It has the Implementation class which is performing the business logic
 * operations on the Prescription Details.
 * </p>
 *
 * @author navaneeth and hari
 */
public interface PrescriptionService {

	/**
	 * <p>
	 * Used to get prescription details from the doctor and added to the
	 * prescriptions details.
	 * </p>
	 *
	 * @param prescription
	 *            Prescription that is used to store a prescription details.
	 * @return prescriptionId Adds prescription and returns prescription unique Id.
	 */
	public int addPrescription(Prescription prescription) throws ApplicationException;

	/**
	 * <p>
	 * Used to update existing prescription details.
	 * </p>
	 *
	 * @param prescription
	 *            Prescription that is used to update a prescription details.
	 * @return prescriptionId Adds prescription and returns prescription unique Id.
	 */
	public boolean modifyPrescription(Prescription prescription) throws ApplicationException;

	/**
	 * <p>
	 * Used to fetch all prescrition details by patientId
	 * </p>
	 * 
	 * @param PatientId
	 *            PatientId that is used to fetch patient prescriptions.
	 * @return prescritions Retrives all the prescrition details of concern patient.
	 */
	public List<Prescription> fetchPrescriptionsByVisitId(int visitId) throws ApplicationException;

	/**
	 * <p>
	 * Used to search a particular prescription details by prescriptionId
	 * </p>
	 * 
	 * @param prescriptionId
	 *            prescriptionId that is used to fetch a particular prescription
	 *            details.
	 * @return prescrition prescrition.
	 */
	public Prescription serchPrescriptionById(int prescriptionId) throws ApplicationException;

	/**
	 * <p>
	 * Used to get all item which is available in store using ajax call
	 * </p>
	 * 
	 * @param prescriptionId
	 *            that is used to fetch a particular prescription details.
	 * @return list list of items like tablet and syrup.
	 */
	public List<ItemMaster> getAllItemsByName(String name) throws ApplicationException;
}