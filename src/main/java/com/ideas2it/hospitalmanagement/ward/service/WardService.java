package com.ideas2it.hospitalmanagement.ward.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.ward.model.Ward;

public interface WardService {
	
	/**
	 * <p>
	 * Create a new ward with all the basic information.
	 * </p>
	 * @param   ward  ward information 
	 * @return        ward information after creation
	 * @throws ApplicationException
	 */
	public Ward createWard(Ward ward, int numberOfRooms) throws ApplicationException;
	
	/**
	 * <p>
	 * Update a ward with all the necessary information.
	 * </p>
	 * @param   ward  ward information 
	 * @return  true  if the ward is updated
	 *          false if the ward is not updated.
	 * @throws ApplicationException
	 */
	public boolean updateWard(Ward ward) throws ApplicationException;
	
	/**
	 * <p>
	 * Search a particular ward with the help of the ward number.
	 * </p>
	 * @param     wardNumber    ward Number
	 * @return    ward          ward information of the particular ward number
	 * @throws ApplicationException
	 */
	public Ward searchWard(Integer wardNumber) throws ApplicationException;
	
	/**
	 * <p>
	 * Delete a particular ward.
	 * </p>
	 * @param   ward  ward information
	 * @return  true  if the ward is deleted
	 *          false if the ward is not deleted.
	 * @throws ApplicationException
	 */
	public boolean deleteWard(Ward ward) throws ApplicationException;

	/**
	 * <p>
	 * display all the wards 
	 * </p>
	 * @param  status   status of the Ward to be searched.
	 * @return
	 * @throws ApplicationException
	 */
	public List<Ward> displayAllWards(String status) throws ApplicationException;
	
	/**
	 * Add rooms to an existing ward with the specified number.
	 * @param ward
	 * @param numberOfRooms
	 * @return
	 * @throws ApplicationException
	 */
	public boolean addRooms(Ward ward, int numberOfRooms) throws ApplicationException;

	public boolean changeWardToFree(Ward ward) throws ApplicationException;
	
	public boolean addRoomsToWard(Ward ward, int numberOfRooms) throws ApplicationException;

	public List<Visit> getVisitsByPatientType(String string) throws ApplicationException;
	
	public Visit searchVisitById(int visitId) throws ApplicationException;
	
	public Bed searchBedByVisit(Visit visitId) throws ApplicationException;

	public Boolean dischargePatient(int bedNumber) throws ApplicationException;
}