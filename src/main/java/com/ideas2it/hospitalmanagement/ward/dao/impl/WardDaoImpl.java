package com.ideas2it.hospitalmanagement.ward.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.ward.commons.constants.WardConstants;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;
import com.ideas2it.hospitalmanagement.ward.model.Ward;


/**
 * <p>
 * WardDAOImpl class takes of creation,updation and retrieval of wards.
 * </p>
 * @author Latheesh
 *
 */
public class WardDaoImpl extends GenericDao implements WardDao{
    
	private static final String INSERT_EXCEPTION =
			"Error occured while inserting the ward: ";
	private static final String UPDATE_EXCEPTION =
			"Error occured while updating the ward: ";
	private static final String ADD_ROOM__EXCEPTION =
			"Error occured while adding rooms to the ward: ";
	private static final String SEARCH__EXCEPTION =
			"Error occured while searching the ward number: ";
	private static final String DISPLAY__EXCEPTION =
			"Error occured while displaying the wards with the status: ";
	private static final String DELETE__EXCEPTION =
			"Error occured while deleting the ward : ";
	private static final String WARD_FREE__EXCEPTION =
			"Error occured while deleting the ward : ";

	
	/**
     *  {@inheritDoc}
     */
    public Ward insertWard(Ward ward) throws ApplicationException {
        try {
  		    ward.setStatus(WardConstants.FREE);
            super.save(ward);
            return ward;
        } catch (ApplicationException e) {
        	StringBuilder errorMessage = new StringBuilder();
        	errorMessage.append(INSERT_EXCEPTION).append(ward);
            Logger.error(errorMessage.toString(), e);
            throw new ApplicationException(errorMessage.toString());
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public boolean updateWard(Ward ward) throws ApplicationException {
        try {
  		    ward.setStatus(WardConstants.UNDERMAINTAINCE);
            return super.update(ward);
        } catch (ApplicationException e) {
        	StringBuilder errorMessage = new StringBuilder();
        	errorMessage.append(UPDATE_EXCEPTION).append(ward);
            Logger.error(errorMessage.toString(), e);
            throw new ApplicationException(errorMessage.toString());
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public boolean addRoomsToWard(Ward ward) throws ApplicationException {
        try {
            return super.update(ward);
        } catch (ApplicationException e) {
        	StringBuilder errorMessage = new StringBuilder();
        	errorMessage.append(ADD_ROOM__EXCEPTION).append(ward);
            Logger.error(errorMessage.toString(), e);
            throw new ApplicationException(errorMessage.toString());
        }
    }

    /**
     *  {@inheritDoc}
     */
    public Ward searchWard(int wardNumber) throws ApplicationException {
    	Ward ward;
        try {
            Session session = null;
            try {
                session = getSession();
                final Criteria criteria = session.createCriteria(Ward.class);
                criteria.add(Restrictions.eq("wardNumber", wardNumber));
                ward = (Ward)criteria.uniqueResult();
                ward.getRooms().size();
            } catch (HibernateException e) {
                Logger.debug(e);
                throw new ApplicationException(e);
            } finally {
                close(session);
            } 
        } catch (ApplicationException e) {
        	StringBuilder errorMessage = new StringBuilder();
        	errorMessage.append(SEARCH__EXCEPTION).append(wardNumber);
            Logger.error(errorMessage.toString(), e);
            throw new ApplicationException(errorMessage.toString());
        }
        return ward;
    }
    
    /**
     *  {@inheritDoc}
     */
    public List<Ward> displayAllWards(String status) throws ApplicationException {
        try {
        	if(WardConstants.ALL.equals(status)) {
        		return super.getAll(Ward.class);
        	} else {
                return super.getAllByAttribute(Ward.class, WardConstants.STATUS, status);
        	}
        } catch (ApplicationException e) {
        	StringBuilder errorMessage = new StringBuilder();
        	errorMessage.append(DISPLAY__EXCEPTION).append(status);
            Logger.error(errorMessage.toString(), e);
            throw new ApplicationException(errorMessage.toString());
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public boolean deleteWard(Ward ward) throws ApplicationException {
        try {
        	ward.setStatus(WardConstants.UNDERMAINTAINCE);
            return super.update(ward);
        } catch (ApplicationException e) {
        	StringBuilder errorMessage = new StringBuilder();
        	errorMessage.append(DELETE__EXCEPTION).append(ward);
            Logger.error(errorMessage.toString(), e);
            throw new ApplicationException(errorMessage.toString());
        }
    }

    /**
     *  {@inheritDoc}
     */
	public boolean changeWardToFree(Ward ward) throws ApplicationException {
        try {
    		ward.setStatus(WardConstants.FREE);
    		return super.update(ward);
        } catch (ApplicationException e) {
        	StringBuilder errorMessage = new StringBuilder();
        	errorMessage.append(WARD_FREE__EXCEPTION).append(ward);
            Logger.error(errorMessage.toString(), e);
            throw new ApplicationException(errorMessage.toString());
        }
	}
}
