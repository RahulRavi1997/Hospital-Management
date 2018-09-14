package com.ideas2it.hospitalmanagement.ward.dao.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;

/**
 * <p>
 * WardDAOImpl class takes of creation,updation and retrieval of wards.
 * </p>
 * @author Latheesh
 *
 */
public class WardDaoImpl extends GenericDao implements WardDao{
    
    /**
     *  {@inheritDoc}
     */
    public Ward insertWard(Ward ward) throws ApplicationException {
        try {
  		  ward.setStatus("free");

            super.save(ward);
            System.out.println("wardnamedaooooo" + ward.getName());
            return ward;
        } catch (ApplicationException e) {
            Logger.error("Ward could not be added", e);
            throw new ApplicationException("Ward could not be added", e);
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public boolean updateWard(Ward ward) throws ApplicationException {
        try {
  		    ward.setStatus("undermaintaince");
            return super.update(ward);
        } catch (ApplicationException e) {
            Logger.error("Ward could not be updated", e );
            throw new ApplicationException("Ward could not be updated", e);
        }
    }
    
    public boolean addRoomsToWard(Ward ward) throws ApplicationException {
        try {
            return super.update(ward);
        } catch (ApplicationException e) {
            Logger.error("Ward could not be updated", e );
            throw new ApplicationException("Ward could not be updated", e);
        }
    }

    
    /**
     *  {@inheritDoc}
     */
    public Ward searchWard(int wardNumber) throws ApplicationException {
        try {
            return super.get(Ward.class, wardNumber);
        } catch (ApplicationException e) {
            Logger.error("Ward could not be retrieved", e);
            throw new ApplicationException("Ward could not be retrieved", e);
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public List<Ward> displayAllWards(String status) throws ApplicationException {

        try {
        	if("All".equals(status)) {
        		return super.getAll(Ward.class);
        	} else {
                return super.getAllByAttribute(Ward.class, "status", status);
        	}
        } catch (ApplicationException e) {
            Logger.error("Wards could not be retrieved", e);
            throw new ApplicationException("Wards could not be retrieved", e);
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public boolean deleteWard(Ward ward) throws ApplicationException {
        try {
        	ward.setStatus("under maintaince");
            return super.update(ward);
        } catch (ApplicationException e) {
            Logger.error("Ward could not be updated", e );
            throw new ApplicationException("Ward could not be updated", e);
        }
    }

	public boolean changeWardToFree(Ward ward) throws ApplicationException {
        try {
    		ward.setStatus("free");
    		return super.update(ward);
        } catch (ApplicationException e) {
            Logger.error("Ward could not be changed to free", e );
            throw new ApplicationException("Ward could not be changed to free", e);
        }
	}

	
	
    
}
