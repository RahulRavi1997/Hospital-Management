package com.ideas2it.hospitalmanagement.visit.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

/**
 * VisitDao is the DAO interface program which is having the methods that is processing the data
 * access operations of the visit Details.
 * <p>
 * It is having the implementation classes, which performs the Add,Modify, Remove,Search and Display
 * the visit details.
 * </p>
 * This interface has a method to gather details of all the visits that are stored in the Database.
 *
 * @author Arul Murugan
 * @version 1.0
 */
public interface VisitDao {

    /**
     * <p>
     * This Method is used when a user wants to Add a visit Object in the Database.This method gets the
     * visit object which contains the visit Details that needs to be added in the database.
     * </p>
     *
     * @param visit visit object type contains the visit details in it.
     * @return true when visit added successfully else returns False.
     */
    public boolean insertVisit(final Visit visit) throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing visit Object in the Database.The new visit Details contains the
     * visit Details which is modified in the Old visit Details.
     * </p>
     *
     * @param visit visit object contains the visit details that needs to be modified.
     * @return boolean returns true when the visit object is modified and false if modification
     *         operation is failed.
     */
    public boolean updateVisit(final Visit visit) throws ApplicationException;

    /**
     * <p>
     * Method to search the visit Id in the database.This method is using the visitId to search the
     * visit and is searched in the database.
     * </p>
     *
     * @param visitId a int datatype which contains the visit id that needs to be searched.
     * @return visit returns visit object when id is found and null when not found.
     */
    public Visit searchVisitById(final Integer visitId) throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the visit Details that were stored in the Database. It gives the
     * visit details as an List.
     * </p>
     *
     * @return visits List with visit datatype containing visit details.
     */
    public List<Visit> getAllVisits() throws ApplicationException;

    /**
     * <p>
     * This Method is used to obtain an List of all selected visits.
     * </p>
     *
     * @return ids an Array of integers containing the id of visits that are to be retrieved.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all visits.
     */
    public List<Visit> getVisitsByIds(Integer[] ids) throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the visit Details that were stored in the Database. It gives the
     * visit details as an List.
     * </p>
     *
     * @param physicianId a int datatype which contains the physicianId and corresponding visit
     *             is searched.
     * @return visits List with visit datatype containing visit details.
     */
    public List<Visit> retrieveByPhysicianId(Integer physicianId) throws ApplicationException;

    /**
     * <p>
     * Method to search the visit Id in the database.This method is using the visitId to search the
     * visit and is searched in the database.
     * </p>
     *
     * @param patientId a int datatype which contains the patientId and corresponding visit
     *             is searched.
     * @return visit returns visit object when id is found and null when not found.
     */
    public Visit searchVisitByPatientId(final Integer patientId) throws ApplicationException;

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
	public List<Visit> getVisitsByPatientType(String patientType) throws ApplicationException;
}

