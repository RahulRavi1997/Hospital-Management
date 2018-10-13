package com.ideas2it.hospitalmanagement.dosage.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * DosageService
 * <p>
 * It act as blueprint of implementing dosageService and which shows some fuctionality like add ,
 * modify , search Dosage of that class.
 * <p>
 * 
 * @author Navaneeth
 */
public interface DosageService {

    /**
     * <p>
     * Used to get dosage details from the doctor and added to the dosages details.
     * </p>
     *
     * @param dosage Dosage that is used to store a dosage details.
     * @return dosageId Adds dosage and returns dosage unique Id.
     */
    public int addDosage(Dosage dosage) throws ApplicationException;

    /**
     * <p>
     * Used to modify a particular dosage details.
     * </p>
     * 
     * @param Dosage Updated dosage details
     * @return boolean Returns wheather its updated or not...
     */
    public boolean modifyDosage(Dosage dosage) throws ApplicationException;

    /**
     * <p>
     * Used to search a particular dosage details by dosageId
     * </p>
     * 
     * @param dosageId dosageId that is used to fetch a particular dosage details.
     * @return dosage dosage details.
     */
    public Dosage serchDosageById(int dosageId) throws ApplicationException;
    
    /**
     * <p>
     * This Method is used to get all dosage which matches the name (for AJAX call purposes)
     * <p>
     *
     * @param , dosageName
     *            the name of the dosage to be searched
     *
     * @return List of Dosage objects which matches the string passed
     * @throws ApplicationException
     *             An exception created for catching exceptions that occur while
     *             searching an Dosage.
     */
    public List<Dosage> getAllDosage(String dosageName) throws ApplicationException;
}
