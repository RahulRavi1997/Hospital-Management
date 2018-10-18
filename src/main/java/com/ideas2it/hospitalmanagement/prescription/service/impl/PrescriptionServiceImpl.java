package com.ideas2it.hospitalmanagement.prescription.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.itemMaster.model.ItemMaster;
import com.ideas2it.hospitalmanagement.itemMaster.service.ItemMasterService;
import com.ideas2it.hospitalmanagement.prescription.service.PrescriptionService;
import com.ideas2it.hospitalmanagement.prescription.dao.PrescriptionDao;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

/**
 * PatientService is the Service interface which is having the several data
 * manipulation methods and this class does the business logic operations on the
 * Patient Details.
 * <p>
 * It has the Implementation class which is performing the business logic
 * operations on the Patient Details.
 * </p>
 *
 * @author Navaneeth and Hari.
 */
public class PrescriptionServiceImpl implements PrescriptionService {

	private PrescriptionDao prescriptionDao;
	private ItemMasterService itemMasterService;

	public PrescriptionDao getPrescriptionDao() {
		return prescriptionDao;
	}

	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
	}

	public ItemMasterService getItemMasterService() {
		return this.itemMasterService;
	}

	public void setItemMasterService(ItemMasterService itemMasterService) {
		this.itemMasterService = itemMasterService;
	}

	/** {@inheritDoc} */
	public List<ItemMaster> getAllItemsByName(String name) throws ApplicationException {
		return itemMasterService.retrieveItemByName(name);
	}

	/** {@inheritDoc} */
	public int addPrescription(Prescription prescription) throws ApplicationException {
		return prescriptionDao.insertPrescription(prescription);
	}

	/** {@inheritDoc} */
	public boolean modifyPrescription(Prescription prescription) throws ApplicationException {
		return prescriptionDao.updatePrescription(prescription);

	}

	/** {@inheritDoc} */
	public List<Prescription> fetchPrescriptionsByVisitId(int visitId) throws ApplicationException {
		return prescriptionDao.retrivePrescriptionsByVisitId(visitId);
	}

	/** {@inheritDoc} */
	public Prescription serchPrescriptionById(int prescriptionId) throws ApplicationException {
		return prescriptionDao.searchPrescription(prescriptionId);
	}
}
