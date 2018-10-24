package com.ideas2it.hospitalmanagement.medicine.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.medicine.model.Medicine;

/**
 * <p>
 * This is a Service-Layer interface used to provide functionality classes  
 * to implement data manipulation operations and business logic on medicine data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface MedicineService {

    /**
     * <p>
     * This method is used to validate and return the status
     * of medicine addition to the database.
     * </p>
     *
     * @return medicineDetails returns true if the details of medicine
     * is added.
     */ 
    public boolean addMedicine(Medicine medicine) throws ApplicationException;

    /**
     * <p>
     * This method is used to return the list of medicine
     * details from the database.
     * </p>
     *
     * @return medicineDetails returns MedicineDetails.
     */
    public List<Medicine> retrieveMedicines() throws ApplicationException;
    
    /**
     * <p>
     * This method is used to delete the medicine 
     * details from the list.
     * </p>
     *
     * @param medicineId Id of the medicine.
     *
     * @return boolean either true or false.
     */
    public boolean deleteMedicine(Medicine medicine) throws ApplicationException;
     
    /**
     * <p>
     * This method is used to update the medicine
     * details in the database.
     * </p>
     *
     * @return true if medicine is updated.
     */ 
    public boolean updateMedicine(Medicine medicine) throws ApplicationException;

    /**
     * <p>
     * This method is used to search the medicine Id
     * and return its details from the database.
     * </p>
     *
     * @param medicineId Id of the medicine.
     *
     * @return Medicine medicine details.
     */
    public Medicine searchMedicine(int medicineId) throws ApplicationException;
    
    /**
     * <p>
     * This method is used to restore the medicine 
     * and return its details from the database.
     * </p>
     *
     * @param medicineId Id of the medicine.
     *
     * @return true if medicine is restored.
     */
	public boolean restoreMedicine(int id) throws ApplicationException;

    /**
     * <p>
     * This method is used to retrieve the medicines from the master medicine
     * details in the database.
     * </p>
     *
     * @return Medicine medicine Details.
     */
    public List<Medicine> retrieveMedicinesByName(String name) throws ApplicationException;
  
}
