package com.ideas2it.hospitalmanagement.medicine.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.medicine.model.Medicine;

/**
 * <p>
 * This is a Data-Access-Object Interface for executing data manipulation
 * operation on Medicine data such as add, update, remove and search.
 * on Medicine details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface MedicineDao { 
    
    /**
     * <p>
     * This method is used to add the Medicine
     * details to the list.
     * </p>
     *
     * @return boolean returns true if the details of Medicine
     * is added to the list.
     */
    public boolean insertMedicine(Medicine medicine) throws ApplicationException;

    /**
     * <p>
     * This method is used to return the medicine
     * details from the list.
     * </p>
     *
     * @return Medicine returns medicineDetails.
     */ 
    public List<Medicine> getAllMedicines() throws ApplicationException;

    /**
     * <p>
     * This method is used to find the Medicine Id
     * and delete its details from the list.
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
     * details in the list.
     * </p>
     *
     * @return true if medicine is updated.
     */ 
    public boolean updateMedicine(Medicine medicine) throws ApplicationException;

    /**
     * <p>
     * This method is used to search the particular medicine
     * detail in the list.
     * </p> 
     *
     * @param medicineId int contains Id of the medicine.
     *
     * @return Medicine details of the medicine.
     */
    public Medicine searchMedicine(int medicineId) throws ApplicationException;
    
	public boolean restoreMedicine(Medicine medicine) throws ApplicationException;

    public List<Medicine> getMedicinesByName(String name) throws ApplicationException;

}
