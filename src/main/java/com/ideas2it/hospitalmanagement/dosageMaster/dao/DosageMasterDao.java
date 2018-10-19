package com.ideas2it.hospitalmanagement.dosageMaster.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.dosageMaster.model.DosageMaster;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * <p>
 * DpsageMasterDao is a Data-Access-Object interface, which is used to provide
 * data access to implement database manipulation operations on Dosage data. It
 * uses a table from Database to store the user Information.
 * </p>
 *
 * @author Hariharasudan K S and Navaneetha Krishnan
 * @version 1.0
 */
public interface DosageMasterDao {

	/**
	 * <p>
	 * Used to add new dosages to master table which by the admin
	 * </p>
	 *
	 * @param dosage DosageMaster that is used to store a dosage details.
	 * @return dosageId Adds dosageMaster and returns dosage unique Id.
	 */
	public int insertDosage(DosageMaster dosage) throws ApplicationException;

	/**
	 * <p>
	 * Used to modify a particular dosage details from Master.
	 * </p>
	 * 
	 * @param Dosage Updated dosagemaster details
	 * @return boolean Returns wheather its updated or not...
	 */

	public boolean updateDosage(DosageMaster dosage) throws ApplicationException;

	/**
	 * <p>
	 * Used to search a particular dosage details from master table by dosageId
	 * </p>
	 * 
	 * @param dosageId dosageId that is used to fetch a particular dosage details.
	 * @return dosage dosage details.
	 */
	public DosageMaster searchDosage(int dosageId) throws ApplicationException;

	/**
	 * <p>
	 * Used to get all dosageMaster items required for AJAX call
	 * </p>
	 * 
	 * @param name string to be matched with master items
	 * @return List of all dosageMaster items which has matched
	 */
	public List<DosageMaster> retrieveDosages(String name);
}
