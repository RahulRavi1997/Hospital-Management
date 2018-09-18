package com.ideas2it.hospitalmanagement.bed.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.hospitalmanagement.bed.dao.BedDao;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

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
	public Bed searchBedByVisit(Visit visit)throws ApplicationException{
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavisit" + visit.getId());
		try {
        	Bed bed =  super.getByAttribute(Bed.class,"visit",visit);
    		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavisit" +
        	bed.getBedNumber());

            return bed;
        } catch (ApplicationException e) {
            Logger.error("Exception occured while searching bed", e);
            throw new ApplicationException("Exception occured while searching bed", e);
        }
	}



}