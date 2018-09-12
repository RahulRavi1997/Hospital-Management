package com.ideas2it.hospitalmanagement.dosage.service.impl;

import com.ideas2it.hospitalmanagement.dosage.dao.DosageDao;
import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.dosage.service.DosageService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

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
	public Dosage serchDosageById(int dosageId) throws ApplicationException {
		return dosageDao.searchDosage(dosageId);
	}
}