package com.ideas2it.hospitalmanagement.patient.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.patient.dao.PatientDao;
import com.ideas2it.hospitalmanagement.patient.dao.impl.PatientDaoImpl;
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
    	Patient oldPatient = patientDao.selectPatientById(patient.
            getId());
    	patient.setVisits(oldPatient.getVisits());
        return patientDao.updateEmployee(patient);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removePatient(final Integer patientId)
            throws ApplicationException {
    	Patient patient = patientDao.selectPatientById(patientId);
        return patientDao.inActivatePatient(patient);
    }

    /**
     * {@inheritDoc}
     */
    public Employee getEmployeeById(final Integer employeeId)
            throws ApplicationException {
        return employeeDao.selectEmployeeById(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> getEmployees()
            throws ApplicationException {
        return employeeDao.getAllEmployees();
    }

    /**
     * {@inheritDoc}
     */
    public boolean activateEmployee(final Integer employeeId)
            throws ApplicationException {
        return employeeDao.activateEmployeeById(employeeId);
    }
}
