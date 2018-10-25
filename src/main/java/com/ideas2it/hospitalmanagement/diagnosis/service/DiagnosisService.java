package com.ideas2it.hospitalmanagement.diagnosis.service;

import java.util.List;
import java.util.Date;

import com.ideas2it.hospitalmanagement.diagnosis.model.Diagnosis;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;;

/**
 * <p>
 * DiagnosisService is a Service-class used to provide logic to Diagnosis
 * operations. All the methods in this class throws Application Exception.
 * Exceptions are thrown if the input data is null. Beans are injected during
 * runtime using Spring IOC.
 * </p>
 *
 * @author Hariharasudan K S
 */
public interface DiagnosisService {

	/**
	 * <p>
	 * This Method is used to add a new diagnosis using the details provided by the
	 * user. Returns true if the entry is added successfully, else returns false.
	 * </p>
	 *
	 * @param diagnosis an Diagnosis object containing all the details of the
	 *                  diagnosis to be added.
	 * @return Boolean a boolean indicating the id of diagnosis that is added.
	 * @throws ApplicationException A Custom Exception created for catching
	 *                              exceptions that occur while adding an diagnosis.
	 */
	public boolean addDiagnosis(Diagnosis diagnosis) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to obtain all the diagnosis details using an list.
	 * Returns an empty list if no diagnosis are added.
	 * </p>
	 *
	 * @return diagnosis a list consisting of all the diagnosis that are added.
	 * @throws ApplicationException A Custom Exception created for catching
	 *                              exceptions that occur while retrieving all
	 *                              diagnosis.
	 */
	public List<Diagnosis> retrieveAllDiagnosis() throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to obtain all the diagnosis details based on date and
	 * patient ID in a list. Returns an empty list if no diagnosis are added.
	 * </p>
	 *
	 * @return diagnosis a list consisting of all the diagnosis that are added.
	 * @return Date Retrieve diagnosis by particular date.
	 * @throws ApplicationException A Custom Exception created for catching
	 *                              exceptions that occur while retrieving all
	 *                              diagnosis.
	 */
	public List<Diagnosis> retrieveDiagnosisByDate(Date date, int patientId) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to modify the details of an existing diagnosis with
	 * updated details provided by the user. Returns true if the diagnosis
	 * information is updated, else returns false if the operation fails.
	 * </p>
	 *
	 * @param daignosis an Daignosis object is passed with the id of the old
	 *                  Diagnosis which is used as a reference.
	 * @return boolean a boolean value is returned whether the operation to modify
	 *         is successful or not.
	 * @throws ApplicationException A Custom Exception created for catching
	 *                              exceptions that occur while modifying a
	 *                              diagnosis.
	 */
	public boolean modifyDiagnosis(Diagnosis diagnosis) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve the details of an existing diagnosis with the
	 * help of its Id
	 * </p>
	 *
	 * @param id The ID of the diagnosis
	 * @return Diagnosis a diagnosis object that matches the ID
	 * @throws ApplicationException A Custom Exception created for catching
	 *                              exceptions that occur while retrieving a
	 *                              diagnosis.
	 */
	public Diagnosis retrieveDiagnosisById(int id) throws ApplicationException;

	/**
	 * <p>
	 * This Method is used to retrieve the details of an existing diagnosis with the
	 * help of its VisitId
	 * </p>
	 *
	 * @param id The VisitId of the patient
	 * @return List a Diagnosis List that matches the Visit ID
	 * @throws ApplicationException A Custom Exception created for catching
	 *                              exceptions that occur while retrieving a
	 *                              diagnosis.
	 */
	public List<Diagnosis> retrieveDiagnosisByVisit(int visitId) throws ApplicationException;

}
