package com.ideas2it.hospitalmanagement.ward.dao.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;

import com.ideas2it.hospitalmanagement.ward.common.Constants;

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
    public boolean insertWard(Ward ward) throws ApplicationException {
        try {
            return (null != super.save(ward));
        } catch (ApplicationException e) {
            Logger.error(Constants.WARD_NOT_ADDED, e);
            throw new ApplicationException(Constants.WARD_NOT_ADDED, e);
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public boolean updateWard(Ward ward) throws ApplicationException {
        try {
            return super.update(ward);
        } catch (ApplicationException e) {
            Logger.error(Constants.WARD_NOT_UPDATED, e );
            throw new ApplicationException(Constants.WARD_NOT_UPDATED, e);
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public Ward searchWard(Ward ward,String attributeName,Object attributeValue) throws ApplicationException {
        try {
            return super.getByAttribute(ward.getClass(),attributeName,attributeValue);
        } catch (ApplicationException e) {
            Logger.error(Constants.WARD_NOT_RETRIEVED, e);
            throw new ApplicationException(Constants.WARD_NOT_RETRIEVED, e);
        }
    }
    
    /**
     *  {@inheritDoc}
     */
    public List<Ward> getAllWards() throws ApplicationException {

        try {
            return super.getAll(Ward.class);
        } catch (ApplicationException e) { 
            Logger.error(Constants.WARDS_NOT_RETRIEVED, e);
            throw new ApplicationException(Constants.WARDS_NOT_RETRIEVED, e);
        }
    }
}
