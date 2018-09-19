package com.ideas2it.hospitalmanagement.patient.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.patient.dao.PatientDao;
import com.ideas2it.hospitalmanagement.patient.model.Patient;

/**
 * PatientDaoImpl is the dao class implements the PatientDao interface and it is processing all the
 * interface methods and this class is having its own method to fetch the ProjectDetails of the
 * Patient.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove, Search and Display the
 * details in the Database implements the PatientDao interface functions.
 * </p>
 * ArrayList is used to store the values of the Patient details which are gathered from the
 * Database.
 *
 * @author Arul Murugan
 * @version 1.0
 */
public class PatientDaoImpl extends GenericDao implements PatientDao {

    public PatientDaoImpl() throws ApplicationException {
        super();
    }

    String PATIENT_IN_QUERY = "from Patient where id in (:ids)";
    String IDS = "ids";
    String PATIENTS_IN_NAMES = "from Patient where firstName like :name";
    String NAME = "name";

    /**
     * {@inheritDoc}
     */
    public boolean insertPatient(final Patient patient) throws ApplicationException {

        patient.setActive(Boolean.TRUE);
        try {
            return (null != super.save(patient));
        } catch (final ApplicationException e) {
            Logger.error(
                    String.format(Constants.PATIENT_ADDITION_EXCEPTION, patient.getFirstName(), patient.getLastName()),
                    e);
            throw new ApplicationException(
                    String.format(Constants.PATIENT_ADDITION_EXCEPTION, patient.getFirstName(), patient.getLastName()),
                    e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean updatePatient(final Patient patient) throws ApplicationException {

        try {
            return super.update(patient);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.PATIENT_EDIT_EXCEPTION, patient.getId()), e);
            throw new ApplicationException(String.format(Constants.PATIENT_EDIT_EXCEPTION, patient.getId()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deletePatient(final Patient patient) throws ApplicationException {

        patient.setActive(Boolean.FALSE);
        return updatePatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public boolean activatePatientById(final Integer patientId) throws ApplicationException {

        final Patient patient = searchPatientById(patientId);
        patient.setActive(Boolean.TRUE);
        return updatePatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public Patient searchPatientById(final Integer patientId) throws ApplicationException {

        try {
            return super.get(Patient.class, patientId);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.PATIENT_SEARCH_EXCEPTION, patientId), e);
            throw new ApplicationException(String.format(Constants.PATIENT_SEARCH_EXCEPTION, patientId));
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Patient> getAllPatients() throws ApplicationException {

        try {
            return super.getAll(Patient.class);
        } catch (final ApplicationException e) {
            Logger.error(Constants.PATIENT_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.PATIENT_DISPLAY_EXCEPTION, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Patient> getPatientsByIds(final Integer[] ids) throws ApplicationException {

        Session session = null;
        try {
            session = super.getSession();
            final Query query = session.createQuery(PATIENT_IN_QUERY);
            query.setParameterList(IDS, ids);
            return query.list();
        } catch (final ApplicationException e) {
            Logger.error(Constants.PATIENT_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.PATIENT_DISPLAY_EXCEPTION, e);
        } finally {
            GenericDao.close(session);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Patient> getPatientsByName(final String name) throws ApplicationException {

        Session session = null;
        try {
            session = super.getSession();
            final Query query = session.createQuery(PATIENTS_IN_NAMES);
            query.setParameter(NAME, name + "%");
            return query.list();
        } catch (final ApplicationException e) {
            Logger.error(Constants.PATIENT_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.PATIENT_DISPLAY_EXCEPTION, e);
        } finally {
            GenericDao.close(session);
        }
    }
}