package com.ideas2it.hospitalmanagement.diagnosis.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.diagnosis.dao.DiagnosisDao;
import com.ideas2it.hospitalmanagement.diagnosis.model.Diagnosis;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;

/**
 * <p>
 * DiagnosisDaoImplementation is a Data-Access-Object Class for executing data
 * manipulation operation on diagnosis data such as add, update, display
 * <p>
 * All the methods in this class throws Application Exception- a custom
 * exception wrapping any exceptions thrown by Hibernate. Soft-delete is done
 * while deleting an employee, setting the status as inactive.
 * </p>
 * 
 * @author Hariharasudan K S
 * @version 1.0
 */
public class DiagnosisDaoImplementation extends GenericDao implements DiagnosisDao {

	public static final String DIAGNOSIS_IN_QUERY = "from Diagnosis where visitId in (:id)";
	public static final String ID = "id";

	public DiagnosisDaoImplementation() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean insertDiagnosis(Diagnosis diagnosis) throws ApplicationException {
		try {
			return (null != super.save(diagnosis));
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.DIAGNOSIS_ADDITION_EXCEPTION, diagnosis.getId()), e);
			throw new ApplicationException(String.format(Constants.DIAGNOSIS_ADDITION_EXCEPTION, diagnosis.getId()), e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Diagnosis> fetchAllDiagnosis() throws ApplicationException {
		try {
			return super.getAll(Diagnosis.class);
		} catch (ApplicationException e) {
			Logger.error(Constants.DIAGNOSIS_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.DIAGNOSIS_DISPLAY_EXCEPTION, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateDiagnosis(Diagnosis diagnosis) throws ApplicationException {
		try {
			return super.update(diagnosis);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.DIAGNOSIS_EDIT_EXCEPTION, diagnosis.getId()), e);
			throw new ApplicationException(String.format(Constants.DIAGNOSIS_EDIT_EXCEPTION, diagnosis.getId()), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Diagnosis> fetchDiagnosisByDate(Date date, int patientId) throws ApplicationException {
		try {
			Session session = super.getSession();
			Query query = session.createQuery(DIAGNOSIS_IN_QUERY);
			query.setParameter(ID, patientId);
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(Constants.DIAGNOSIS_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.DIAGNOSIS_DISPLAY_EXCEPTION, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */

	public List<Diagnosis> fetchDiagnosisByVisit(int visitId) throws ApplicationException {
		try {
			Session session = super.getSession();
			Query query = session.createQuery(DIAGNOSIS_IN_QUERY);
			query.setParameter(ID, visitId);
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(Constants.DIAGNOSIS_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.DIAGNOSIS_DISPLAY_EXCEPTION, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Diagnosis searchDiagnosisById(int id) throws ApplicationException {
		try {
			return super.get(Diagnosis.class, id);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.ITEM_SEARCH_EXCEPTION, id), e);
			throw new ApplicationException(String.format(Constants.ITEM_SEARCH_EXCEPTION, id), e);
		}
	}

}
