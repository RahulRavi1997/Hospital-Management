package com.ideas2it.hospitalmanagement.user.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.user.dao.UserDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
/**
 * <p>
 * UserDaoImpl is a Data-Access-Object Class for executing data manipulation
 * operation on user data such as add, update, remove and search. 
 * All the methods in this class throw Application Exception.
 * </p>
 * 
 * @author    Rahul Ravi
 * @version   1.0
 */
public class UserDaoImpl extends GenericDao implements UserDao {

    public  UserDaoImpl() throws ApplicationException {
        super();
    }
    
    String USER_IN_QUERY = "from User where id in (:ids)";
    String IDS = "ids";
    String QUERY = "query";
    String USER_AUTOCOMPLETE_QUERY = "From User where email like :query order by email";
    /**
     *  {@inheritDoc}
     */
    public Boolean insertUser(User user) throws ApplicationException {

        user.setActive(Boolean.TRUE);
        try {
            return (null != super.save(user));
        } catch (ApplicationException e) {
            Logger.error(String.format(Constants.USER_ADDITION_EXCEPTION, user.getEmail()), e);
            throw new ApplicationException(String.format(Constants.USER_ADDITION_EXCEPTION, user.getEmail()), e);
        }
    }

    /**
     *  {@inheritDoc}
     */
    public User searchUserByEmail(String email) throws ApplicationException {

        try {
            return super.getByAttribute(User.class, Constants.EMAIL, email);
        } catch (ApplicationException e) {
            Logger.error(String.format(Constants.USER_SEARCH_EXCEPTION, email), e);
            throw new ApplicationException(String.format(Constants.USER_SEARCH_EXCEPTION, email), e);
        }
    }

	/**
	 *  {@inheritDoc}
	 */
	public List<User> getAllUsers() throws ApplicationException {

		try {
			return super.getAll(User.class);
		} catch (ApplicationException e) {
			Logger.error(Constants.USER_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.USER_DISPLAY_EXCEPTION, e);
		}
	}

    /**
     * {@inheritDoc}
     */
    public boolean updateUser(User user) throws ApplicationException {

        try {
            return super.update(user);
        } catch (ApplicationException e) {
            Logger.error(String.format(
                Constants.USER_EDIT_EXCEPTION, user.getId()), e);
            throw new ApplicationException(String.format(
                Constants.USER_EDIT_EXCEPTION, user.getId()), e);
        }
    }

    /**
     *  {@inheritDoc}
     */
    public boolean deleteUser(User user)
            throws ApplicationException {

        user.setActive(Boolean.FALSE);
        return updateUser(user);
    }

    /**
     *  {@inheritDoc}
     */
    public boolean restoreUser(User user)
            throws ApplicationException {

        user.setActive(Boolean.TRUE);
        return updateUser(user);
    }


    /**
     *  {@inheritDoc}
     */
    public User searchUserById(Integer id) throws ApplicationException {

        try {
            return super.get(User.class, id);
        } catch (ApplicationException e) {
            Logger.error(String.format(Constants.USER_SEARCH_EXCEPTION, id), e);
            throw new ApplicationException(String.format(Constants.USER_SEARCH_EXCEPTION, id));
        }
    }

    /**
     *  {@inheritDoc}
     */
    public List<User> getUsersByIds(Integer[] ids) throws ApplicationException {

        try {
            Session session = super.getSession();
            Query query = session.createQuery(USER_IN_QUERY);  
            query.setParameterList(IDS, ids); 
            return query.list();
        } catch (ApplicationException e) {
            Logger.error(Constants.USER_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.USER_DISPLAY_EXCEPTION, e);
        }
    }
    
	public List<User> getUsersByQuery(String autoCompleteQuery) throws ApplicationException {
		
        try {
            Session session = super.getSession();
            Query query = session.createQuery(USER_AUTOCOMPLETE_QUERY);  
            query.setParameter(QUERY, autoCompleteQuery + "%" ); 
            return query.setMaxResults(10).list();
        } catch (ApplicationException e) {
            Logger.error(Constants.USER_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.USER_DISPLAY_EXCEPTION, e);
        }
		
	}

}
