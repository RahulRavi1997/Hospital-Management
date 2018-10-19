package com.ideas2it.hospitalmanagement.user.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.user.dao.UserDao;
import com.ideas2it.hospitalmanagement.user.model.User;

/**
 * <p>
 * UserDaoImpl is a Data-Access-Object Class for executing data manipulation operation on user data
 * such as add, update, remove and search. All the methods in this class throw Application
 * Exception.
 * </p>
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public class UserDaoImpl extends GenericDao implements UserDao {

    public UserDaoImpl() throws ApplicationException {
        super();
    }

    String USER_IN_QUERY = "from User where id in (:ids)";
    String IDS = "ids";
    String QUERY = "query";
    String ROLE = "role";
    String ACTIVE = "active";
    String USER_AUTOCOMPLETE_QUERY = "From User where email like :query and role = : role and active like :active order by email";

    /**
     * {@inheritDoc}
     */
    public Boolean insertUser(final User user) throws ApplicationException {

        user.setActive(Boolean.TRUE);
        try {
            return (null != super.save(user));
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.USER_ADDITION_EXCEPTION, user.getEmail()), e);
            throw new ApplicationException(String.format(Constants.USER_ADDITION_EXCEPTION, user.getEmail()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public User searchUserByEmail(final String email) throws ApplicationException {

        try {
            return super.getByAttribute(User.class, Constants.EMAIL, email);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.USER_SEARCH_EXCEPTION, email), e);
            throw new ApplicationException(String.format(Constants.USER_SEARCH_EXCEPTION, email), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getAllUsers() throws ApplicationException {

        try {
            return super.getAll(User.class);
        } catch (final ApplicationException e) {
            Logger.error(Constants.USER_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.USER_DISPLAY_EXCEPTION, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateUser(final User user) throws ApplicationException {

        try {
            return super.update(user);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.USER_EDIT_EXCEPTION, user.getId()), e);
            throw new ApplicationException(String.format(Constants.USER_EDIT_EXCEPTION, user.getId()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteUser(final User user) throws ApplicationException {

        user.setActive(Boolean.FALSE);
        return updateUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public boolean restoreUser(final User user) throws ApplicationException {

        user.setActive(Boolean.TRUE);
        return updateUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public User searchUserById(final Integer id) throws ApplicationException {

        try {
            return super.get(User.class, id);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.USER_SEARCH_EXCEPTION, id), e);
            throw new ApplicationException(String.format(Constants.USER_SEARCH_EXCEPTION, id));
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsersByIds(final Integer[] ids) throws ApplicationException {

        try {
            final Session session = super.getSession();
            final Query query = session.createQuery(USER_IN_QUERY);
            query.setParameterList(IDS, ids);
            return query.list();
        } catch (final ApplicationException e) {
            Logger.error(Constants.USER_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.USER_DISPLAY_EXCEPTION, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsersByQuery(final String autoCompleteQuery, final String role) throws ApplicationException {

        try {
            final Session session = super.getSession();
            final Query query = session.createQuery(USER_AUTOCOMPLETE_QUERY);
            query.setParameter(QUERY, autoCompleteQuery);
            query.setParameter(ROLE, role);
            query.setParameter(ACTIVE, Boolean.TRUE);
            return query.setMaxResults(10).list();
        } catch (final ApplicationException e) {
            Logger.error(Constants.USER_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.USER_DISPLAY_EXCEPTION, e);
        }

    }

}
