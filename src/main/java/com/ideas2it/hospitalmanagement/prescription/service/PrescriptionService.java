package com.ideas2it.hospitalmanagement.prescription.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

/**
 * PrescriptionService
 * <p>
 *  It act as blueprint of implementing prescriptionService and  which shows some fuctionality 
 *  like add , modify , remove Prescription of that class. 
 * <p>
 * @author Navaneeth 
 */
public interface PrescriptionService {
	
	/**
     * <p>
     *  Used to get prescription details from 
     *  the doctor and added to the prescriptions details. 
     * </p>
     *
     * @param     prescription      Prescription that is used to store 
     *                              a prescription details.
     * @return   prescriptionId     Adds prescription and returns prescription unique Id. 
     */
	public int addPrescription(Prescription prescription) throws ApplicationException; 
	
	/**
     * <p>
     *  Used to update existing prescription details  
     * </p>
     *
     * @param    prescription       Prescription that is used to update 
     *                              a prescription details.
     * @return   prescriptionId     Adds prescription and returns prescription unique Id. 
     */
	public boolean modifyPrescription(Prescription prescription) throws ApplicationException;
	
	/**
     * <p>
     *  Used to fetch all prescrition details by patientId
     * </p>
     * 
     * @param      PatientId         PatientId that is used to fetch 
     *                               patient prescriptions.
     * @return    prescritions       Retrives all the prescrition details of concern patient. 
     */
	public List<Prescription> fetchPrescriptionsByPatientId(int patientId) throws ApplicationException;
	
	/**
     * <p>
     *  Used to search a particular prescription details by prescriptionId
     * </p>
     * 
     * @param     prescriptionId     prescriptionId that is used to fetch 
     *                               a particular prescription details.
     * @return    prescrition        prescrition. 
     */
     public Prescription serchPrescriptionById(int prescriptionId) throws ApplicationException;
}