package com.ideas2it.hospitalmanagement.prescription.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.prescription.service.PrescriptionService;
import com.ideas2it.hospitalmanagement.prescription.dao.PrescriptionDao;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

public class PrescriptionServiceImpl implements PrescriptionService{
	
    private PrescriptionDao prescriptionDao;
	
    public PrescriptionDao getPrescriptionDao() {
		return prescriptionDao;
	}

	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
	}
    
	/**{@inheritDoc}*/ 
	public int addPrescription(Prescription prescription) throws ApplicationException  {
	    return prescriptionDao.insertPrescription(prescription);
    }
	
	/**{@inheritDoc}*/
	public boolean modifyPrescription(Prescription prescription) throws ApplicationException  {
     	return prescriptionDao.updatePrescription(prescription);	
	
	}	
	/**{@inheritDoc}*/
	public List<Prescription> fetchPrescriptionsByPatientId(int patientId) throws ApplicationException {
		return prescriptionDao.retrivePrescriptionsByPatientId(patientId);
	}
	
	/**{@inheritDoc}*/
	public Prescription serchPrescriptionById(int prescriptionId) throws ApplicationException {
		return prescriptionDao.searchPrescription(prescriptionId);
	}		
}