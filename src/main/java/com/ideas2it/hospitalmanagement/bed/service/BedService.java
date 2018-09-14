package com.ideas2it.hospitalmanagement.bed.service;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

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
	public boolean dischargePatient(int visitId, int bedNumber) throws ApplicationException;
	
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
}