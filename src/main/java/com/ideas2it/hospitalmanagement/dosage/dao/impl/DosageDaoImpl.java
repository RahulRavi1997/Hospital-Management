package com.ideas2it.hospitalmanagement.dosage.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ideas2it.hospitalmanagement.dosage.dao.DosageDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.dosage.model.Dosage;

/**
 * DosageDaoImp is the class which is having the methods that is processing the
 * data access operations of the Dosage Details.
 * <p>
 * It is having the methods, which performs the Add,Modify, Remove,Search and
 * Display the dosage details.
 * </p>
 *
 * @author navaneeth and hari.
 */
public class DosageDaoImpl extends GenericDao implements DosageDao {
	private static final String INSERT_ERROR_INFO = "Error occured while Adding dosage in prescription";
	private static final String UPDATE_ERROR_INFO = "Error occured while updating dosage Id:";
	private static final String SEARCH_ERROR_INFO = "Error occured while fetching dosage dosage Id:";
	private static final String DOSAGE_IN_NAMES = "from Dosage where DOSAGE like :name";
	private static final String NAMES = "name";

	/** {@inheritDoc} */
	public int insertDosage(Dosage dosage) throws ApplicationException {
		try {
			return GenericDao.save(dosage).getDosageId();
		} catch (ApplicationException e) {
			Logger.error(INSERT_ERROR_INFO + dosage, e);
			throw new ApplicationException(e);
		}
	}

	/** {@inheritDoc} */
	public boolean updateDosage(Dosage dosage) throws ApplicationException {
		try {
			return GenericDao.update(dosage);
		} catch (ApplicationException e) {
			Logger.error(UPDATE_ERROR_INFO + dosage.getDosageId(), e);
			throw new ApplicationException(e);
		}
	}

	/** {@inheritDoc} */
	public Dosage searchDosage(int dosageId) throws ApplicationException {
		try {
			return GenericDao.get(Dosage.class, dosageId);
		} catch (ApplicationException e) {
			Logger.error(SEARCH_ERROR_INFO + dosageId, e);
			throw new ApplicationException(e);
		}
	}

	/** {@inheritDoc} */
	public List<Dosage> retrieveDosages(String dosageName) throws ApplicationException {
		try {
			Session session = super.getSession();
			Query query = session.createQuery(DOSAGE_IN_NAMES);
			query.setParameter(NAMES, dosageName + "%");
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(SEARCH_ERROR_INFO + dosageName, e);
			throw new ApplicationException(e);
		}
	}
}