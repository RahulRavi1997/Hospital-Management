package com.ideas2it.hospitalmanagement.dosage.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.dosage.dao.DosageDao;
import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.dosage.service.DosageService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * DosageService
 * <p>
 * It act as blueprint of implementing dosageService and which shows some
 * fuctionality like add , modify , search Dosage of that class.
 * <p>
 * 
 * @author Navaneeth
 */
public class DosageServiceImpl implements DosageService {

	private DosageDao dosageDao;

	public DosageDao getDosageDao() {
		return dosageDao;
	}

	public void setDosageDao(DosageDao dosageDao) {
		this.dosageDao = dosageDao;
	}

	/** {@inheritDoc} */
	public int addDosage(Dosage dosage) throws ApplicationException {
		return dosageDao.insertDosage(dosage);
	}

	/** {@inheritDoc} */
	public boolean modifyDosage(Dosage dosage) throws ApplicationException {
		return dosageDao.updateDosage(dosage);

	}

	/** {@inheritDoc} */
	public List<Dosage> getAllDosage(String dosageName) throws ApplicationException {
		return dosageDao.retrieveDosages(dosageName);

	}

	/** {@inheritDoc} */
	public Dosage serchDosageById(int dosageId) throws ApplicationException {
		return dosageDao.searchDosage(dosageId);
	}
}
