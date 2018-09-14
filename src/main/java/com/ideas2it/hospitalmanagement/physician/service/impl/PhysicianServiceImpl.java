package com.ideas2it.hospitalmanagement.physician.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.physician.service.PhysicianService;
import com.ideas2it.hospitalmanagement.physician.model.Physician;
import com.ideas2it.hospitalmanagement.physician.dao.impl.PhysicianDaoImpl;
import com.ideas2it.hospitalmanagement.physician.dao.PhysicianDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.commons.Constants;

public class PhysicianServiceImpl implements PhysicianService {
	
	public static PhysicianDao physicianDao = null;

	public void setPhysicianDao(PhysicianDao physicianDao) {
		this.physicianDao = physicianDao;
	}

	public PhysicianDao getPhysicianDao() {
		return this.physicianDao;
	}

	/**
	 *  {@inheritDoc}
	 */
	public Boolean addPhysician(Physician physician) throws ApplicationException {

		return physicianDao.insertPhysician(physician);
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean modifyPhysician(Physician physician)
			throws ApplicationException {

		if (null == physician) {
			throw new ApplicationException(Constants.ID_NOT_NULL);
		}
		return physicianDao.updatePhysician(physician);
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean restorePhysician(int id) throws ApplicationException {
		Physician physician = retrievePhysicianById(id);
		if(null == physician) {
			return Boolean.FALSE;
		}
		return physicianDao.restorePhysician(physician);
	}


	/**
	 *  {@inheritDoc}
	 */
	public boolean deletePhysician(Integer id)
			throws ApplicationException {

		if (null == id) {
			throw new ApplicationException(Constants.ID_NOT_NULL);
		}
		Physician physician = retrievePhysicianById(id);
		if(null == physician) {
			return Boolean.FALSE;
		}
		return physicianDao.deletePhysician(physician);
	}

	/**
	 *  {@inheritDoc}
	 */
	public Physician retrievePhysicianById(Integer id)
			throws ApplicationException {

		if (null == id) {
			throw new ApplicationException(Constants.ID_NOT_NULL);
		}
		return physicianDao.searchPhysicianById(id);
	}

	/**
	 *  {@inheritDoc}
	 */
	public List<Physician> retrieveAllPhysicians() throws ApplicationException {

		return physicianDao.getAllPhysicians();
	}

	/**
	 *  {@inheritDoc}
	 */
	public List<Physician> retrievePhysiciansByIds(Integer[] ids) throws ApplicationException {
		return physicianDao.getPhysiciansByIds(ids);
	}
}
