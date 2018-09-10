package com.ideas2it.hospitalmanagement.physician.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.physician.dao.PhysicianDao;
import com.ideas2it.hospitalmanagement.physician.model.Physician;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;

import javassist.bytecode.CodeIterator.Gap;

import org.hibernate.Session;
import org.hibernate.Query;

public class PhysicianDaoImpl extends GenericDao implements PhysicianDao {


	String PHYSICIAN_IN_QUERY = "from Physician where id in (:ids)";
	String IDS = "ids";
	public PhysicianDaoImpl() throws ApplicationException {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean insertPhysician(Physician physician) throws ApplicationException {

		physician.setActive(Boolean.TRUE);
		try {
			return (null != super.save(physician));
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.
					PHYSICIAN_ADDITION_EXCEPTION, physician.getFirstName(), physician.getLastName()), e);
			throw new ApplicationException(String.format(Constants.
					PHYSICIAN_ADDITION_EXCEPTION, physician.getFirstName(), physician.getLastName()), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updatePhysician(Physician physician) throws ApplicationException {

		try {
			return super.update(physician);
		} catch (ApplicationException e) {
			Logger.error(String.format(
					Constants.PHYSICIAN_EDIT_EXCEPTION, physician.getId()), e);
			throw new ApplicationException(String.format(
					Constants.PHYSICIAN_EDIT_EXCEPTION, physician.getId()), e);
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean deletePhysician(Physician physician)
			throws ApplicationException {

		physician.setActive(Boolean.FALSE);
		return updatePhysician(physician);
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean restorePhysician(Physician physician)
			throws ApplicationException {

		physician.setActive(Boolean.TRUE);
		return updatePhysician(physician);
	}


	/**
	 *  {@inheritDoc}
	 */
	public Physician searchPhysicianById(Integer id) throws ApplicationException {

		try {
			return super.get(Physician.class, id);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.PHYSICIAN_SEARCH_EXCEPTION, id), e);
			throw new ApplicationException(String.format(Constants.PHYSICIAN_SEARCH_EXCEPTION, id));
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	public List<Physician> getAllPhysicians() throws ApplicationException {

		try {
			return super.getAll(Physician.class);
		} catch (ApplicationException e) {
			Logger.error(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	public List<Physician> getPhysiciansByIds(Integer[] ids) throws ApplicationException {

		try {
			Session session = super.getSession();
			Query query = session.createQuery(PHYSICIAN_IN_QUERY);  
			query.setParameterList(IDS, ids); 
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.PHYSICIAN_DISPLAY_EXCEPTION, e);
		}
	}

}
