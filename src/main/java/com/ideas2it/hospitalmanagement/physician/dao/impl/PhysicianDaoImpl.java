package com.ideas2it.hospitalmanagement.physician.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.physician.dao.PhysicianDao;
import com.ideas2it.hospitalmanagement.physician.model.Physician;

/**
 * PhysicianDaoImpl is a Dao Implementation Class used to implement Database related Operations. All
 * the methods in this class throw a custom Application Exception.
 * 
 * @author Rahul Ravi
 * @version 1.0
 */
public class PhysicianDaoImpl extends GenericDao implements PhysicianDao {

    String PHYSICIAN_IN_QUERY = "from Physician where id in (:ids)";
    String IDS = "ids";

    String PHYSICIAN_SPECIALISATION_QUERY = "from Physician where specialisation in (:specialisation)";
    String SPECIALISATION = "specialisation";

    public PhysicianDaoImpl() throws ApplicationException {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public Boolean insertPhysician(final Physician physician) throws ApplicationException {

        physician.setActive(Boolean.TRUE);
        try {
            return (null != super.save(physician));
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.PHYSICIAN_ADDITION_EXCEPTION, physician.getFirstName(),
                    physician.getLastName()), e);
            throw new ApplicationException(String.format(Constants.PHYSICIAN_ADDITION_EXCEPTION,
                    physician.getFirstName(), physician.getLastName()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean updatePhysician(final Physician physician) throws ApplicationException {

        try {
            return super.update(physician);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.PHYSICIAN_EDIT_EXCEPTION, physician.getId()), e);
            throw new ApplicationException(String.format(Constants.PHYSICIAN_EDIT_EXCEPTION, physician.getId()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deletePhysician(final Physician physician) throws ApplicationException {

        physician.setActive(Boolean.FALSE);
        return updatePhysician(physician);
    }

    /**
     * {@inheritDoc}
     */
    public boolean restorePhysician(final Physician physician) throws ApplicationException {

        physician.setActive(Boolean.TRUE);
        return updatePhysician(physician);
    }

    /**
     * {@inheritDoc}
     */
    public Physician searchPhysicianById(final Integer id) throws ApplicationException {
        try {
            return super.get(Physician.class, id);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.PHYSICIAN_SEARCH_EXCEPTION, id), e);
            throw new ApplicationException(String.format(Constants.PHYSICIAN_SEARCH_EXCEPTION, id));
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Physician> getAllPhysicians() throws ApplicationException {

        try {
            return super.getAll(Physician.class);
        } catch (final ApplicationException e) {
            Logger.error(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Physician> getPhysiciansByIds(final Integer[] ids) throws ApplicationException {

        try {
            final Session session = super.getSession();
            final Query query = session.createQuery(PHYSICIAN_IN_QUERY);
            query.setParameterList(IDS, ids);
            return query.list();
        } catch (final ApplicationException e) {
            Logger.error(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Physician> getPhysiciansBySpecialisation(final String specialisation) throws ApplicationException {

        try {
            final Session session = super.getSession();
            final Query query = session.createQuery(PHYSICIAN_SPECIALISATION_QUERY);
            query.setParameter(SPECIALISATION, specialisation);
            return query.list();
        } catch (final ApplicationException e) {
            Logger.error(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
            throw new ApplicationException(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
        }

    }

    /**
     * {@inheritDoc}
     */
    public Integer searchPhysicianByUserId(final Integer userId) throws ApplicationException {

        try {
            final Session session = super.getSession();
            String sql = "SELECT id FROM physicians where USER_ID =" + userId;
            Query query = session.createSQLQuery(sql);
            return (Integer)query.uniqueResult();
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.PHYSICIAN_SEARCH_EXCEPTION, userId), e);
            throw new ApplicationException(String.format(Constants.PHYSICIAN_SEARCH_EXCEPTION, userId));
        }
    }
}
