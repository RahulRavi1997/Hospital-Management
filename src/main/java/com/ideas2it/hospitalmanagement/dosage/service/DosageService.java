package com.ideas2it.hospitalmanagement.dosage.service;

import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * DosageService
 * <p>
 *  It act as blueprint of implementing dosageService and  which shows some fuctionality 
 *  like add , modify , search Dosage of that class. 
 * <p>
 * @author Navaneeth 
 */
public interface DosageService {
	
	/**
     * <p>
     *  Used to get dosage details from 
     *  the doctor and added to the dosages details. 
     * </p>
     *
     * @param    dosage      Dosage that is used to store 
     *                        a dosage details.
     * @return   dosageId     Adds dosage and returns dosage unique Id. 
     */
	public int addDosage(Dosage dosage) throws ApplicationException;
	
	/**
     * <p>
     *  Used to modify a particular dosage details.
     * </p>
     * 
     * @param     Dosage      Updated dosage details
     *  
     * @return    boolean     Returns wheather its updated or not...   
     */
	public boolean modifyDosage(Dosage dosage) throws ApplicationException;
	
	/**
     * <p>
     *  Used to search a particular dosage details by dosageId
     * </p>
     * 
     * @param     dosageId     dosageId that is used to fetch 
     *                         a particular dosage details.
     * @return    dosage       dosage details. 
     */
	public Dosage serchDosageById(int dosageId) throws ApplicationException;
}