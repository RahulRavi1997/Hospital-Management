package com.ideas2it.hospitalmanagement.user.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.user.dao.UserDao;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.user.service.UserService;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;
import com.ideas2it.hospitalmanagement.visit.model.Visit;


/**
 * </p>
 * UserServiceImpl is a Service-class used to provide logic to User operations. All the methods in
 * this class throws Application Exception. Exceptions are thrown if the input data is null. Beans
 * are injected during runtime using Spring IOC.
 * </p>
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    public UserDao userDao = null;

    private VisitService visitService = null;

    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    public VisitService getVisitService() {
        return this.visitService;
    }


    public void setUserDao(final UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return this.userDao;
    }

    /**
     * {@inheritDoc}
     */
    public Boolean addUser(final User user) throws ApplicationException {

        if (null == user) {
            throw new ApplicationException(Constants.INVALID_INPUT);
        }
        return userDao.insertUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public User retrieveUserByEmail(final String email) throws ApplicationException {

        if (null == email) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userDao.searchUserByEmail(email);
    }

    /**
     * {@inheritDoc}
     */
    public List<User> retrieveAllUsers() throws ApplicationException {

        return userDao.getAllUsers();
    }

    /**
     * {@inheritDoc}
     */
    public List<User> retrieveUsersByQuery(final String query, final String role) throws ApplicationException {

        return userDao.getUsersByQuery(query, role);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyUser(final User user) throws ApplicationException {

        if (null == user) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userDao.updateUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public boolean restoreUser(final int id) throws ApplicationException {
        final User user = retrieveUserById(id);
        if (null == user) {
            return Boolean.FALSE;
        }
        return userDao.restoreUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteUser(final Integer id) throws ApplicationException {

        if (null == id) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        final User user = retrieveUserById(id);
        if (null == user) {
            return Boolean.FALSE;
        }
        return userDao.deleteUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public User retrieveUserById(final Integer id) throws ApplicationException {

        if (null == id) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userDao.searchUserById(id);
    }

    /**
     * {@inheritDoc}
     */
    public List<User> retrieveUsersByIds(final Integer[] ids) throws ApplicationException {
        return userDao.getUsersByIds(ids);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Visit> getAllVisitsByPatientType(String status) throws ApplicationException {
        return visitService.getVisitsByPatientType("InPatient");
    }


}
