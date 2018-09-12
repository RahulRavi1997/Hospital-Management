package com.ideas2it.hospitalmanagement.dosage.dao.impl;

import com.ideas2it.hospitalmanagement.dosage.dao.DosageDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.dosage.model.Dosage;


public class DosageDaoImpl implements DosageDao {
	private static final String INSERT_ERROR_INFO =
			"Error occured while Adding dosage in prescription";  
	private static final String UPDATE_ERROR_INFO =
			"Error occured while updating dosage Id:"; 
	private static final String SEARCH_ERROR_INFO =
		"Error occured while fetching dosage dosage Id:"; 
	
	/**{@inheritDoc}*/
    public int insertDosage(Dosage dosage) throws ApplicationException  {
	    try {   
			return GenericDao.save(dosage).getDosageId();
		} catch (ApplicationException e) {
			Logger.error(INSERT_ERROR_INFO, e); 
		    throw new ApplicationException(e);
	    }
	}
	
    /**{@inheritDoc}*/
	public boolean updateDosage(Dosage dosage) throws ApplicationException  {
		try { 
			return GenericDao.update(dosage);
		} catch (ApplicationException e) {
			Logger.error(UPDATE_ERROR_INFO+dosage.getDosageId(), e);
		    throw new ApplicationException(e);
	    }
	}
	
	/**{@inheritDoc}*/
	public Dosage searchDosage(int dosageId) throws ApplicationException {
		try { 
            return GenericDao.get(Dosage.class, dosageId);
		} catch (ApplicationException e) {
			Logger.error(SEARCH_ERROR_INFO, e); 
		    throw new ApplicationException(e);
	    }		
    }		
}