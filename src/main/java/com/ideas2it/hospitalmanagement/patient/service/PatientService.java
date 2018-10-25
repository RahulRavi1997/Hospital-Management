package com.ideas2it.hospitalmanagement.patient.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.patient.model.Patient;

/**
 * PatientService is the Service interface which is having the several data manipulation methods and
 * this class does the business logic operations on the Patient Details.
 * <p>
 * It has the Implementation class which is performing the business logic operations on the Patient
 * Details.
 * </p>
 *
 * @author Arul Murugan
 * @version 1.0
 */
public interface PatientService {

    /**
     * <p>
     * This Method is used if a user wants to Add Patient Details. It gets the Patient object which
     * contains all the information about the patient that needs to be added.
     * </p>
     *
     * @param patient Patient object type contains the Patient details that needs to be added.
     * @return boolean returns true when Patient object added successfully and return false when
     *         addition operation fails .
     * @exception throws Application Exception when the Patient Object is not inserted due to any
     *            connection error, same Patient EmailId or same PatientId.
     */
    public boolean addPatient(final Patient patient) throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Patient Details with new details.The Patient Id is searched by
     * using searchPatientById method and the details are modified.
     * </p>
     *
     * @param patient Patient object contains the New Patient details that that is modified in old
     *                patient.
     * @return boolean returns true when the Patient object is modified and false if modification
     *         operation is failed.
     * @exception throws Application Exception when the Patient Object is not updated due to any
     *            connection error or Patient Id not found.
     */
    public boolean modifyPatient(final Patient patient) throws ApplicationException;

    /**
     * <p>
     * Method to remove the Existing Patient Details.The Patient object contains employeeId is searched
     * using searchEmployeebyId method and the details is removed.
     * </p>
     *
     * @param patientId an Integer object which contains the Patient Details that needs to be removed.
     * @return boolean returns true when the Patient object is deleted and false if deletion operation
     *         is failed.
     * @exception throws Application Exception when the patient Object is not deleted due to any
     *            connection error or patientId not found.
     */
    public boolean removePatient(final Integer patientId) throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing Patient Id.This method is using the PatientId to search and returns
     * the searched Patient Object.
     * </p>
     *
     * @param patientId a int datatype which contains the Patient id that needs to be searched.
     * @return returns Patient object when id is found and null when not found.
     * @exception throws Application Exception when the Patient Object is not searched due to any
     *            connection error or PatientId not found.
     */
    public Patient getPatientById(final Integer patientId) throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Patient Details that were stored. It gives the Patient details
     * as an List.
     * </p>
     *
     * @return List with patient datatype containing Patient details.
     * @exception throws Application Exception when the Patient details cannot be retrieved due to any
     *            connection error or Patient not found.
     */
    public List<Patient> getPatients() throws ApplicationException;

    /**
     * <p>
     * Method to activate the Inactive Patient Details.The Patient id is given to ActivatePatient method
     * and the Patient Details is activated.
     * </p>
     *
     * @param patientId an integer object which contains the Patient Id that needs to be activated.
     * @return boolean returns true when the Patient object is activated and false if activation
     *         operation is failed.
     * @throws ApplicationException when failure occurs in activating the Patient Object details.
     */
    public boolean activatePatient(final Integer patientId) throws ApplicationException;

    /**
     * <p>
     * This Method is used to retrieve an list of all selected Patients.
     * </p>
     *
     * @param ids an Array of integers containing the id of Patients that are to be retrieved.
     * @return List of Patients from the given array of Ids.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all Patients.
     */
    public List<Patient> retrievePatientsByIds(Integer[] ids) throws ApplicationException;

}