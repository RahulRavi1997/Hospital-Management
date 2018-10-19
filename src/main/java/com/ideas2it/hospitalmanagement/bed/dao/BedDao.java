package com.ideas2it.hospitalmanagement.bed.dao;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

public interface BedDao {

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
	public Bed searchBedByNumber(int bedNumber)throws ApplicationException;

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
	public boolean updateBed(Bed bed)throws ApplicationException;
	
	/**
     * <p>
     * searchBedByVisit method is used to search a specific bed associated
     * with a visit
     * </p>
     * 
     * @param Bed 								Bed object
     * 
     * @return boolean 							Indicates whether the bed 
     *											is updated or not
     */
    public Bed searchBedByVisit(Visit visit)throws ApplicationException;

}