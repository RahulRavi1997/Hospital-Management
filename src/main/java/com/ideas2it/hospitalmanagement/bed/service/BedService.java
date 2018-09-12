package com.ideas2it.hospitalmanagement.bed.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;


public interface BedService {
	
	/**
	 * Display all the beds which are free for the purpose of
	 * admitting the patient.
	 * @param status
	 * @return     list of bed which are free.
	 */
	public List<Bed> retrieveBedsByStatus(String status) throws ApplicationException;
	
	
	/**
	 * Create a new bed with all the bed information.
	 * @param bed
	 * @return
	 * @throws ApplicationException
	 */
	public Bed createBed(Bed bed) throws ApplicationException;
	
	
}
