package com.ideas2it.hospitalmanagement.user.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.user.dao.UserDao;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.user.service.UserService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * </p>
 * UserServiceImpl is a Service-class used to provide logic to User operations.
 * All the methods in this class throws Application Exception. Exceptions are
 * thrown if the input data is null.
 * Beans are injected during runtime using Spring IOC.
 * </p>
 *
 * @author    Rahul Ravi
 * @version   1.0
 */
public class UserServiceImpl implements UserService {

    public UserDao userDao = null;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return this.userDao;
    }


    /**
     *  {@inheritDoc}
     */
    public Boolean addUser(User user) throws ApplicationException {

        if (null == user) {
            throw new ApplicationException(Constants.INVALID_INPUT);
        }
        return userDao.insertUser(user);
    }

    /**
     *  {@inheritDoc}
     */
    public User retrieveUserByEmail(String email)
            throws ApplicationException {

        if (null == email) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userDao.searchUserByEmail(email);
    }

	/**
	 *  {@inheritDoc}
	 */
	public List<User> retrieveAllUsers() throws ApplicationException {

		return userDao.getAllUsers();
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public List<User> retrieveUsersByQuery(String query, String role) throws ApplicationException {

		return userDao.getUsersByQuery(query, role);
	}
	

    /**
     *  {@inheritDoc}
     */
    public boolean modifyUser(User user)
            throws ApplicationException {

        if (null == user) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userDao.updateUser(user);
    }

    /**
     *  {@inheritDoc}
     */
    public boolean restoreUser(int id) throws ApplicationException {
        User user = retrieveUserById(id);
        if(null == user) {
            return Boolean.FALSE;
        }
        return userDao.restoreUser(user);
    }


    /**
     *  {@inheritDoc}
     */
    public boolean deleteUser(Integer id)
            throws ApplicationException {

        if (null == id) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        User user = retrieveUserById(id);
        if(null == user) {
            return Boolean.FALSE;
        }
        return userDao.deleteUser(user);
    }

    /**
     *  {@inheritDoc}
     */
    public User retrieveUserById(Integer id)
            throws ApplicationException {

        if (null == id) {
            throw new ApplicationException(Constants.ID_NOT_NULL);
        }
        return userDao.searchUserById(id);
    }

    /**
     *  {@inheritDoc}
     */
    public List<User> retrieveUsersByIds(Integer[] ids) throws ApplicationException {
        return userDao.getUsersByIds(ids);
    }
}

