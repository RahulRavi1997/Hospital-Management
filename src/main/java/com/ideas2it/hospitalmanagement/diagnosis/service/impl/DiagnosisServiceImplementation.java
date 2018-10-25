package com.ideas2it.hospitalmanagement.diagnosis.service.impl;

import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.diagnosis.dao.DiagnosisDao;
import com.ideas2it.hospitalmanagement.diagnosis.model.Diagnosis;
import com.ideas2it.hospitalmanagement.diagnosis.service.DiagnosisService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * <p>
 * DiagonisServiceImplementation is a Service-class used to provide logic to
 * Diagnosis operations. All the methods in this class throws Application
 * Exception. Exceptions are thrown if the input data is null. Beans are
 * injected during runtime using Spring IOC.
 * </p>
 *
 * @author Hariharasudan K S
 * @version 1.0
 */
@Service
public class DiagnosisServiceImplementation implements DiagnosisService {

	public static DiagnosisDao diagnosisDao;

	public void setDiagnosisDao(DiagnosisDao diagnosisDao) {
		this.diagnosisDao = diagnosisDao;
	}

	public DiagnosisDao getDiagnosisDao() {
		return this.diagnosisDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean addDiagnosis(Diagnosis diagnosis) throws ApplicationException {
		return diagnosisDao.insertDiagnosis(diagnosis);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Diagnosis> retrieveDiagnosisByDate(Date date, int patientId) throws ApplicationException {
		return diagnosisDao.fetchDiagnosisByDate(date, patientId);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Diagnosis> retrieveAllDiagnosis() throws ApplicationException {
		return diagnosisDao.fetchAllDiagnosis();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean modifyDiagnosis(Diagnosis diagnosis) throws ApplicationException {
		if (diagnosis == null) {
			throw new ApplicationException(Constants.ID_NOT_NULL);
		}
		return diagnosisDao.updateDiagnosis(diagnosis);
	}

	/**
	 * {@inheritDoc}
	 */
	public Diagnosis retrieveDiagnosisById(int id) throws ApplicationException {
		return diagnosisDao.searchDiagnosisById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Diagnosis> retrieveDiagnosisByVisit(int visitId) throws ApplicationException {
		return diagnosisDao.fetchDiagnosisByVisit(visitId);

	}
}
