package com.ideas2it.hospitalmanagement.patient.service.impl;

import java.util.Date;
import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.patient.dao.PatientDao;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
import com.ideas2it.hospitalmanagement.patient.service.PatientService;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;

/**
 * PatientServiceImpl is the Service class implementing the PatientService interface and this
 * implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to do the data accessing
 * operations.
 * </p>
 *
 * @author Arul Murugan
 * @version 1.0
 */
public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;
    private VisitService visitService;

    public void setPatientDao(final PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public void setVisitService(final VisitService visitService) {
        this.visitService = visitService;
    }

    /**
     * {@inheritDoc}
     */
    public boolean addPatient(final Patient patient) throws ApplicationException {
        return patientDao.insertPatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyPatient(final Patient patient) throws ApplicationException {
        return patientDao.updatePatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removePatient(final Integer patientId) throws ApplicationException {
        final Visit visit = visitService.getVisitByPatientId(patientId);
        if (null != visit) {
            visit.setDischargeDate(new Date());
            visit.getPatient().setActive(Boolean.FALSE);
            return visitService.modifyVisit(visit, visit.getPatient().getId(),
                    visit.getPhysician().getId());
        } else {
            final Patient patient = patientDao.searchPatientById(patientId);
            return patientDao.deletePatient(patient);
        }
    }

    /**
     * {@inheritDoc}
     */
    public Patient getPatientById(final Integer patientId) throws ApplicationException {
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
    public boolean activatePatient(final Integer patientId) throws ApplicationException {
        return patientDao.activatePatientById(patientId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Patient> retrievePatientsByIds(final Integer[] ids) throws ApplicationException {
        return patientDao.getPatientsByIds(ids);
    }

}
