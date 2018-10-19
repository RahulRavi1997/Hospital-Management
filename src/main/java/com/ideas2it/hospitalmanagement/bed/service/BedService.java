package com.ideas2it.hospitalmanagement.bed.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.ward.model.Ward;

public interface BedService {
	
    /**
     * <p>
     * admitPatient method is used to discharge a patient from his assigned
     * bed
     * </p>
     * 
     * @param bedNumber 						Bed Number
     * @param visitId							Visit Id
     * 
     * @return boolean 							Indicates whether the patient 
     *											has been admitted or not
     */
	public boolean admitPatient(int visitId, int bedNumber) throws ApplicationException;
	
    /**
     * <p>
     * searchBedByNumber method is used to retrieve the bed for a given bed 
     * number
     * </p>
     * 
     * @param bedNumber 						Bed Number
     * 
     * @return Bed 								Bed object
     */
	public Bed searchBedByNumber(int bedNumber) throws ApplicationException;
	
    /**
     * <p>
     * dischargePatient method is used to discharge a patient from his assigned
     * bed
     * </p>
     * 
     * @param bedNumber 						Bed Number
     * @param visitId							Visit Id
     * 
     * @return boolean 							Indicates whether the patient 
     *											has been discharged or not
     */
	public boolean dischargePatient(int bedNumber) throws ApplicationException;
	
    /**
     * <p>
     * updateBed method is used to update the modified bed in the database.
     * </p>
     * 
     * @param Bed 								Bed object
     * 
     * @return boolean 							Indicates whether the bed 
     *											is updated or not
     */
	public boolean updateBed(Bed bed) throws ApplicationException;
	
	/**
	 * <p>
	 * getWardsByStatus returns all wards based upon the status
	 * </p>
	 * @param  status   						status of the Ward to be searched.
	 * 
	 * @return List<Ward>						List of wards
	 */
	public List<Ward> getWardsByStatus(String status) throws ApplicationException;

	/**
	 * <p>
	 * getVisitsByPatientType returns all visits based upon the patient type
	 * </p>
	 * @param  status   						status of the Ward to be searched.
	 * 
	 * @return List<Visit>						List of visits
	 */
    public List<Visit> getVisitsByPatientType(String string)throws ApplicationException;

    /**
	 * <p>
	 * searchvisitByNumber is used for searching the visit for the given visit Id.
	 * </p>
	 * @param  visitId   						Visit ID
	 * 
	 * @return Visit 							Visit Object
	 */
	public Visit searchvisitByNumber(int visitId) throws ApplicationException;
	
	
	/**
	 * <p>
	 * searchBedByVisit is used for finding the bed for a given visit.
	 * </p>
	 * @param  visit   							Visit object
	 * 
	 * @return Bed								Bed object
	 */
    public Bed searchBedByVisit(Visit visit) throws ApplicationException;
	
	/**
	 * <p>
	 * display all the wards 
	 * </p>
	 * @param  status   status of the Ward to be searched.
	 * @return
	 * @throws ApplicationException
	 */
	public List<Ward> displayAllWards(String status) throws ApplicationException;
}