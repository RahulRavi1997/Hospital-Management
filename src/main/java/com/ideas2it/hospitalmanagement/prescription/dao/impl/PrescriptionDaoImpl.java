package com.ideas2it.hospitalmanagement.prescription.dao.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.prescription.dao.PrescriptionDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;


public class PrescriptionDaoImpl implements PrescriptionDao{
	private static final String INSERT_ERROR_INFO =
			 "Error occured while Adding prescription in patient Id:";  
	private static final String UPDATE_ERROR_INFO =
			 "Error occured while updating prescription Id:"; 
	private static final String DISPLAY_ERROR_INFO =
			 "Error occured while fetching prescriptions"; 
	private static final String SEARCH_ERROR_INFO =
		"Error occured while fetching prescription prescription Id:"; 
	
	/**{@inheritDoc}*/
    public int insertPrescription(Prescription prescription) throws ApplicationException  {
	    try {   
			return GenericDao.save(prescription).getId();
		} catch (ApplicationException e) {
			Logger.error(INSERT_ERROR_INFO+prescription.getId(), e); 
		    throw new ApplicationException(e);
	    }
	}
	
    /**{@inheritDoc}*/
	public boolean updatePrescription(Prescription prescription) throws ApplicationException  {
		try { 
			return GenericDao.update(prescription);
		} catch (ApplicationException e) {
			Logger.error(UPDATE_ERROR_INFO+prescription.getId(), e);
		    throw new ApplicationException(e);
	    }
	}
	
	/**{@inheritDoc}*/
	public List<Prescription> retrivePrescriptionsByPatientId(int patientId) throws ApplicationException  {
		try { 
            return GenericDao.getAllByAttribute(Prescription.class, "patientId" ,patientId);
		} catch (ApplicationException e) {
			Logger.error(DISPLAY_ERROR_INFO, e); 
		    throw new ApplicationException(e);
	    }
	}
	
	/**{@inheritDoc}*/
	public Prescription searchPrescription(int prescriptionId) throws ApplicationException {
		try { 
            return GenericDao.get(Prescription.class, prescriptionId);
		} catch (ApplicationException e) {
			Logger.error(DISPLAY_ERROR_INFO, e); 
		    throw new ApplicationException(e);
	    }		
    }		
}