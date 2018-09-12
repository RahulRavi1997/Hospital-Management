package com.ideas2it.hospitalmanagement.diagnosis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.diagnosis.dao.DiagnosisDao;
import com.ideas2it.hospitalmanagement.diagnosis.model.Diagnosis;
import com.ideas2it.hospitalmanagement.diagnosis.service.DiagnosisService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
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
	public boolean createDiagnosis(Diagnosis diagnosis) throws ApplicationException {

		return diagnosisDao.insertDiagnosis(diagnosis);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Diagnosis> retrieveDiagnosisByDate(Date date,int patientId) throws ApplicationException {
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
	 * 
	 * @return
	 */
	public boolean modifyDiagnosis(Diagnosis diagnosis) throws ApplicationException {
		if (diagnosis == null) {
			throw new ApplicationException(Constants.ID_NOT_NULL);
		}
		return diagnosisDao.updateDiagnosis(diagnosis);
	}
}
