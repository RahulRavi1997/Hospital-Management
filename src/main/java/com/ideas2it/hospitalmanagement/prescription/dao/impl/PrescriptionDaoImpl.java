package com.ideas2it.hospitalmanagement.prescription.dao.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.prescription.dao.PrescriptionDao;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

/**
 * PrescriptionDaoImp is the class which is having the methods that is
 * processing the data access operations of the Prescription Details.
 * <p>
 * It is having the methods, which performs the Add,Modify, Remove,Search and
 * Display the prescription details.
 * </p>
 *
 * @author navaneeth and hari.
 */
public class PrescriptionDaoImpl implements PrescriptionDao {
	private static final String INSERT_ERROR_INFO = "Error occured while Adding prescription in patient Id:";
	private static final String UPDATE_ERROR_INFO = "Error occured while updating prescription Id:";
	private static final String DISPLAY_ERROR_INFO = "Error occured while fetching prescriptions";

	/** {@inheritDoc} */
	public int insertPrescription(Prescription prescription) throws ApplicationException {
		try {
			return GenericDao.save(prescription).getId();
		} catch (ApplicationException e) {
			Logger.error(INSERT_ERROR_INFO + prescription.getId(), e);
			throw new ApplicationException(e);
		}
	}

	/** {@inheritDoc} */
	public boolean updatePrescription(Prescription prescription) throws ApplicationException {
		try {
			return GenericDao.update(prescription);
		} catch (ApplicationException e) {
			Logger.error(UPDATE_ERROR_INFO + prescription.getId(), e);
			throw new ApplicationException(e);
		}
	}

	/** {@inheritDoc} */
	public List<Prescription> retrivePrescriptionsByVisitId(int visitId) throws ApplicationException {
		try {
			return GenericDao.getAllByAttribute(Prescription.class, "visitId", visitId);
		} catch (ApplicationException e) {
			Logger.error(DISPLAY_ERROR_INFO+visitId, e);
			throw new ApplicationException(e);
		}
	}

	/** {@inheritDoc} */
	public Prescription searchPrescription(int prescriptionId) throws ApplicationException {
		try {
			return GenericDao.get(Prescription.class, prescriptionId);
		} catch (ApplicationException e) {
			Logger.error(DISPLAY_ERROR_INFO+prescriptionId, e);
			throw new ApplicationException(e);
		}
	}
}