package com.ideas2it.hospitalmanagement.dosageMaster.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.dosageMaster.model.DosageMaster;
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
public interface DosageMasterService {

	/**
	 * <p>
	 * Used to get dosage details from the doctor and added to the dosages details.
	 * </p>
	 *
	 * @param dosage
	 *            Dosage that is used to store a dosage details.
	 * @return dosageId Adds dosage and returns dosage unique Id.
	 */
	public int addDosage(DosageMaster dosageMaster) throws ApplicationException;

	/**
	 * <p>
	 * Used to modify a particular dosage details.
	 * </p>
	 * 
	 * @param Dosage
	 *            Updated dosage details
	 * @return boolean Returns wheather its updated or not...
	 */
	public boolean modifyDosage(DosageMaster dosageMaster) throws ApplicationException;

	/**
	 * <p>
	 * Used to search a particular dosage details by dosageId
	 * </p>
	 * 
	 * @param dosageId
	 *            dosageId that is used to fetch a particular dosage details.
	 * @return dosage dosage details.
	 */
	public DosageMaster searchDosageMasterById(int dosageId) throws ApplicationException;

	/**
	 * <p>
	 * Used to get all dosages for Ajax call
	 * </p>
	 * 
	 * @param name
	 *            String that is used to match the dosage name
	 * @return List of all dosage details.
	 */
	public List<DosageMaster> getAllDosage(String name);

}
