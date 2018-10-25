package com.ideas2it.hospitalmanagement.patient.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.patient.model.Patient;

/**
 * PatientDao is the DAO interface program which is having the methods that is processing the data
 * access operations of the Patient Details.
 * <p>
 * It is having the implementation classes, which performs the Add,Modify, Remove,Search and Display
 * the Patient details.
 * </p>
 * This interface has a method to gather details of all the Patients that are stored in the
 * Database.
 *
 * @author Arul Murugan
 * @version 1.0
 */
public interface PatientDao {

    /**
     * <p>
     * This Method is used when a user wants to Add a Patient Object in the Database.This method gets
     * the Patient object which contains the Patient Details that needs to be added in the database.
     * </p>
     *
     * @param Patient Patient object type contains the Patient details in it.
     * @return true when Patient added successfully else returns False.
     */
    public boolean insertPatient(final Patient patient) throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Patient Object in the Database.The new Patient Details contains the
     * Patient Details which is modified in the Old Patient Details.
     * </p>
     *
     * @param Patient Patient object contains the Patient details that needs to be modified.
     * @return boolean returns true when the Patient object is modified and false if modification
     *         operation is failed.
     */
    public boolean updatePatient(final Patient patient) throws ApplicationException;

    /**
     * <p>
     * Method to inactivate the Existing Patient Object in the Database. The Patient Object is fetched
     * from PatientId and the Patient Object is inactivated the Old Patient Details.
     * </p>
     *
     * @param Patient Patient object contains the Patient details that needs to be inactivated.
     * @return boolean returns true when the Patient object is inactivated and false if operation is
     *         failed.
     * @throws ApplicationException when failure occurs while deactivating a Patient Details.
     */
    public boolean deletePatient(final Patient patient) throws ApplicationException;

    /**
     * <p>
     * Method to search the Patient Id in the database.This method is using the PatientId to search the
     * Patient and is searched in the database.
     * </p>
     *
     * @param patientId a int datatype which contains the Patient id that needs to be searched.
     * @return Patient returns Patient object when id is found and null when not found.
     */
    public Patient searchPatientById(final Integer patientId) throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Patient Details that were stored in the Database. It gives the
     * Patient details as an List.
     * </p>
     *
     * @return Patients List with Patient datatype containing Patient details.
     */
    public List<Patient> getAllPatients() throws ApplicationException;

    /**
     * <p>
     * Method to Activate the Existing Patient Object in the Database. The Patient Object is fetched
     * from PatientId and the Patient Object is Activated the Old Patient Details.
     * </p>
     *
     * @param patientId a int datatype which contains the Patient id that needs to be Activated.
     * @return boolean returns true when the Patient object is Activated and false if operation is
     *         failed.
     * @throws ApplicationException when failure occurs while Activating a Patient Details.
     */
    public boolean activatePatientById(final Integer patientId) throws ApplicationException;

    /**
     * <p>
     * This Method is used to obtain an List of all selected Patients.
     * </p>
     *
     * @param ids an Array of integers containing the id of Patients that are to be retrieved.
     * @return List of Patient in the given array of ids
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all Patients.
     */
    public List<Patient> getPatientsByIds(Integer[] ids) throws ApplicationException;
}