package com.ideas2it.hospitalmanagement.prescription.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

public interface PrescriptionDao{
	
    public int insertPrescription(Prescription prescription) throws ApplicationException;
	
	public boolean updatePrescription(Prescription prescription) throws ApplicationException; 
	
	public List<Prescription> retrivePrescriptionsByPatientId(int patientId) throws ApplicationException;
	
	public Prescription searchPrescription(int prescriptionId) throws ApplicationException; 
}