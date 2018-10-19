package com.ideas2it.hospitalmanagement.visit.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

/**
 * VisitService is the Service interface which is having the several data manipulation methods and
 * this class does the business logic operations on the visit Details.
 * <p>
 * It has the Implementation class which is performing the business logic operations on the visit
 * Details.
 * </p>
 *
 * @author Arul Murugan
 * @version 1.0
 */
public interface VisitService {

    /**
     * <p>
     * This Method is used if a user wants to Add visit Details. It gets the visit object which contains
     * all the information about the visit that needs to be added.
     * </p>
     *
     * @param visit visit object type contains the visit details that needs to be added.
     * @param patientId Integer with patientId value from which the Patient Object is obtained.
     * @param physicianId Integer with physicianId value from which the physician Object is obtained.
     * @return boolean returns true when visit object added successfully and return false when addition
     *         operation fails .
     * @exception throws Application Exception when the visit Object is not inserted due to any
     *            connection error, same visit EmailId or same visitId.
     */
    public boolean addVisit(final Visit visit, final Integer patientId, final Integer physicianId)
            throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing visit Details with new details.The visit Id is searched by using
     * searchvisitById method and the details are modified.
     * </p>
     *
     * @param visit visit object contains the New visit details that that is modified in old visit.
     * @return boolean returns true when the visit object is modified and false if modification
     *         operation is failed.
     * @exception throws Application Exception when the visit Object is not updated due to any
     *            connection error or visit Id not found.
     */
    public boolean modifyVisit(final Visit visit, final Integer patientId, final Integer physicianId)
            throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing visit Id.This method is using the visitId to search and returns the
     * searched visit Object.
     * </p>
     *
     * @param visitId a int datatype which contains the visit id that needs to be searched.
     * @return returns visit object when id is found and null when not found.
     * @exception throws Application Exception when the visit Object is not searched due to any
     *            connection error or visitId not found.
     */
    public Visit getVisitById(final Integer visitId) throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the visit Details that were stored. It gives the visit details as
     * an List.
     * </p>
     *
     * @return List with visit datatype containing visit details.
     * @exception throws Application Exception when the visit details cannot be retrieved due to any
     *            connection error or visit not found.
     */
    public List<Visit> getVisits() throws ApplicationException;

    /**
     * <p>
     * This Method is used to retrieve an list of all selected visits.
     * </p>
     *
     * @return ids an Array of integers containing the id of visits that are to be retrieved.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all visits.
     */
    public List<Visit> retrieveVisitsByIds(Integer[] ids) throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing visit Id.This method is using the visitId to search and returns the
     * searched visit Object.
     * </p>
     *
     * @param patientId a int datatype which contains the patientId that needs to be searched.
     * @return returns visit object when id is found and null when not found.
     * @exception throws Application Exception when the visit Object is not searched due to any
     *            connection error or visitId not found.
     */
    public Visit getVisitByPatientId(final Integer patientId) throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing visit Id.This method is using the visitId to search and returns the
     * searched visit Object.
     * </p>
     *
     * @param physicianId a int datatype which contains the physicianId that needs to be searched.
     * @return returns visit object when id is found and null when not found.
     * @exception throws Application Exception when the visit Object is not searched due to any
     *            connection error or visitId not found.
     */
	public List<Visit> getVisitsByPhysicianId(Integer physicianId) throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing visit Id.This method is using the visitId to search and returns the
     * searched visit Object.
     * </p>
     *
     * @param patientId a int datatype which contains the patientId that needs to be searched.
     * @param session HttpSession which is used to set the Patient Object to session level.
     * @return returns visit object when id is found and null when not found.
     * @exception throws Application Exception when the visit Object is not searched due to any
     *            connection error or visitId not found.
     */
    public Visit getVisitForPatientId(final Integer patientId, HttpSession session) throws ApplicationException;

    /**
     * <p>
     * This Method is used to obtain an List of all selected visits by patient Type.
     * </p>
     *
     * @param patientType containing the patient Type.
     * @return visits an List of Visit containing the id of visits that are to be retrieved.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all visits.
     */
    public List<Visit> getVisitsByPatientType(String patientType)
        throws ApplicationException;
}
