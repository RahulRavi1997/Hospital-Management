package com.ideas2it.hospitalmanagement.bed.dao.impl;

import com.ideas2it.hospitalmanagement.bed.dao.BedDao;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;

import java.util.List;

/**
 * <p>
 * BedDaoImpl class takes of creation,updation and retrieval of wards.
 * </p>
 * @author Latheesh
 *
 */
public class BedDaoImpl extends GenericDao implements BedDao{
   
    /**
     *  {@inheritDoc}
     */
    public List<Bed> displayAllBedsByStatus(String status) throws ApplicationException {
         try {
             return super.getAllByAttribute(Bed.class, "Status", status);
         } catch (ApplicationException e) {
             Logger.error("Beds could not be retrieved", e);
             throw new ApplicationException("Beds could not be retrieved", e);
         }
    }
    
    /**
     *  {@inheritDoc}
     */
    public Bed createBed(Bed bed) throws ApplicationException {
         try {
             return super.save(bed);
         } catch (ApplicationException e) {
             Logger.error("Bed could not be added", e);
             throw new ApplicationException("Bed could not be added", e);
         }
    }
}
