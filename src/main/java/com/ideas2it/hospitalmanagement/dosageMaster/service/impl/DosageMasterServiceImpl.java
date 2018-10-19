package com.ideas2it.hospitalmanagement.dosageMaster.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.dosageMaster.dao.DosageMasterDao;
import com.ideas2it.hospitalmanagement.dosageMaster.model.DosageMaster;
import com.ideas2it.hospitalmanagement.dosageMaster.service.DosageMasterService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * DosageService
 * <p>
 * It is a class which implements dosageService and perform operations like add
 * , modify , search Dosage.
 * <p>
 * 
 * @author Navaneeth
 */
public class DosageMasterServiceImpl implements DosageMasterService {

	private DosageMasterDao dosageMasterDao;

	public DosageMasterDao getDosageMasterDao() {
		return dosageMasterDao;
	}

	public void setDosageMasterDao(DosageMasterDao dosageMasterDao) {
		this.dosageMasterDao = dosageMasterDao;
	}

	/** {@inheritDoc} */
	public int addDosage(DosageMaster dosage) throws ApplicationException {
		return dosageMasterDao.insertDosage(dosage);
	}

	/** {@inheritDoc} */
	public boolean modifyDosage(DosageMaster dosageMaster) throws ApplicationException {
		return dosageMasterDao.updateDosage(dosageMaster);

	}

	/** {@inheritDoc} */
	public DosageMaster serchDosageById(int dosageId) throws ApplicationException {
		return dosageMasterDao.searchDosage(dosageId);
	}

	/** {@inheritDoc} */
	public DosageMaster searchDosageMasterById(int dosageId) throws ApplicationException {
		return dosageMasterDao.searchDosage(dosageId);
	}

	/** {@inheritDoc} */
	public List<DosageMaster> getAllDosage(String name) {
		return dosageMasterDao.retrieveDosages(name);
	}
}
