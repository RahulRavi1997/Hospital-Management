package com.ideas2it.hospitalmanagement.patient.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.patient.dao.PatientDao;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
import com.ideas2it.hospitalmanagement.patient.service.PatientService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * PatientServiceImpl is the Service class implementing the EmployeeService
 * interface and this implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to
 * do the data accessing operations.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao ;

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    /**
     * {@inheritDoc}
     */
    public boolean addPatient(final Patient patient)
            throws ApplicationException {
        return patientDao.insertPatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyPatient(final Patient patient)
            throws ApplicationException {
    	Patient oldPatient = patientDao.searchPatientById(patient.
            getId());
    	patient.setVisits(oldPatient.getVisits());
        return patientDao.updatePatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removePatient(final Integer patientId)
            throws ApplicationException {
    	Patient patient = patientDao.searchPatientById(patientId);
        return patientDao.deletePatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public Patient getPatientById(final Integer patientId)
            throws ApplicationException {
        return patientDao.searchPatientById(patientId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Patient> getPatients()
            throws ApplicationException {
        return patientDao.getAllPatients();
    }

    /**
     * {@inheritDoc}
     */
    public boolean activatePatient(final Integer patientId)
            throws ApplicationException {
        return patientDao.activatePatientById(patientId);
    }
    
	/**
	 *  {@inheritDoc}
	 */
	public List<Patient> retrievePatientsByIds(Integer[] ids) throws ApplicationException {
		return patientDao.getPatientsByIds(ids);
	}
}