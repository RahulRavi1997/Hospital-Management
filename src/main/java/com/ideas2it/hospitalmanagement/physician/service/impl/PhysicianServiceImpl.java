package com.ideas2it.hospitalmanagement.physician.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.physician.dao.PhysicianDao;
import com.ideas2it.hospitalmanagement.physician.model.Physician;
import com.ideas2it.hospitalmanagement.physician.service.PhysicianService;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.user.service.UserService;

/**
 * PhysicianServiceImpl is a Service Class used to implement Business-Logic. All the methods in this
 * class throw a custom Application Exception. Implementation beans are injected in runtime using
 * Spring IOC.
 * 
 * @author Rahul Ravi
 * @version 1.0
 */
public class PhysicianServiceImpl implements PhysicianService {

    public static PhysicianDao physicianDao = null;

    public void setPhysicianDao(final PhysicianDao physicianDao) {
        this.physicianDao = physicianDao;
    }

    public PhysicianDao getPhysicianDao() {
        return this.physicianDao;
    }

    private UserService userService = null;

    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return this.userService;
    }

    /**
     * {@inheritDoc}
     */
    public Boolean addPhysician(final Physician physician) throws ApplicationException {

        return physicianDao.insertPhysician(physician);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyPhysician(final Physician physician) throws ApplicationException {

        if (null == physician) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return physicianDao.updatePhysician(physician);
    }

    /**
     * {@inheritDoc}
     */
    public boolean restorePhysician(final int id) throws ApplicationException {
        final Physician physician = retrievePhysicianById(id);
        if (null == physician) {
            return Boolean.FALSE;
        }
        return physicianDao.restorePhysician(physician);
    }

    /**
     * {@inheritDoc}
     */
    public boolean deletePhysician(final Integer id) throws ApplicationException {

        if (null == id) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        final Physician physician = retrievePhysicianById(id);
        if (null == physician) {
            return Boolean.FALSE;
        }
        return physicianDao.deletePhysician(physician);
    }

    /**
     * {@inheritDoc}
     */
    public Physician retrievePhysicianById(final Integer id) throws ApplicationException {

        if (null == id) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return physicianDao.searchPhysicianById(id);
    }

    /**
     * {@inheritDoc}
     */
    public Integer retrievePhysicianByUserId(final Integer userId) throws ApplicationException {

        if (null == userId) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return physicianDao.searchPhysicianByUserId(userId);
    }


    /**
     * {@inheritDoc}
     */
    public List<Physician> retrieveAllPhysicians() throws ApplicationException {

        return physicianDao.getAllPhysicians();
    }

    /**
     * {@inheritDoc}
     */
    public User retrieveUserByEmail(final String email) throws ApplicationException {

        if (null == email) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userService.retrieveUserByEmail(email);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyUser(final User user) throws ApplicationException {

        if (null == user) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userService.modifyUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public List<Physician> retrievePhysiciansBySpecialisation(final String specialisation) throws ApplicationException {

        return physicianDao.getPhysiciansBySpecialisation(specialisation);
    }

}
