package com.ideas2it.hospitalmanagement.bed.dao.impl;

import com.ideas2it.hospitalmanagement.bed.dao.BedDao;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;

public class BedDaoImpl extends GenericDao implements BedDao {

	/**
	 *  {@inheritDoc}
	 */
	public Bed searchBedByNumber(int bedNumber) throws ApplicationException {
		try {
        	return super.getByAttribute(Bed.class,"bedNumber",bedNumber);
        } catch (ApplicationException e) {
            Logger.error("Exception occured while searching bed", e);
            throw new ApplicationException("Exception occured while searching bed", e);
        }
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean updateBed(Bed bed) throws ApplicationException {
        try {
            return super.update(bed);
        } catch (ApplicationException e) {
            Logger.error("Bed not updated", e );
            throw new ApplicationException("Bed not updated", e);
        }
	}	
}