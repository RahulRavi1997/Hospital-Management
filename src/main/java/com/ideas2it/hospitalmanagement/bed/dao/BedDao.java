package com.ideas2it.hospitalmanagement.bed.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.ward.model.Ward;

/**
 * <p>
 * BedDAO is an interface which holds methods for creation and updation of beds.
 * </p>
 * @author Latheesh
 *
 */
public interface BedDao {
    
    /**
     *  <p>
     *  createBed is used to create a bed and store it in the database.
     *  </p>
     *  
     *  @param bed                             Bed object
     *  
     *  @return bed                         Bed object
     */
    public Bed createBed(Bed bed) throws ApplicationException;
    
    /**
     *  <p>
     *  createBed is used to create a bed and store it in the database.
     *  </p>
     *  
     *  @param status                         Status of the bed
     *  
     *  @return List<Bed>                     List of bed objects
     */
    public List<Bed> displayAllBeds() throws ApplicationException;
    
    
    public boolean updateBed(Bed bed) throws ApplicationException;

}