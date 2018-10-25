package com.ideas2it.hospitalmanagement.bed.dao.impl;

import com.ideas2it.hospitalmanagement.bed.commons.constants.BedConstants;
import com.ideas2it.hospitalmanagement.bed.dao.BedDao;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

/**
 * BedDaoImpl is the dao class implements the bedDao interface and it is
 * processing all the interface methods and this class is having its own method
 * to fetch the bedallocation details of the visit.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove, Search
 * and Display the details in the Database implements the BedDao interface
 * functions.
 * </p>
 * ArrayList is used to store the values of the bed details which are gathered
 * from the Database.
 *
 * @author latheesh
 * @version 1.0
 */

public class BedDaoImpl extends GenericDao implements BedDao {

	private static final String ERROR_SEARCHING_BED = "Exception occured while searching bed : ";
	private static final String ERROR_UPDATING_BED = "Exception occured while updating bed : ";
	private static final String ERROR_SEARCHING_BED_BY_VISIT = "Exception occured while searching bed by visit : ";

	/**
	 * {@inheritDoc}
	 */
	public Bed searchBedByNumber(int bedNumber) throws ApplicationException {
		try {
			return super.getByAttribute(Bed.class, BedConstants.BEDNUMBER, bedNumber);
		} catch (ApplicationException e) {
			String message = new StringBuilder().append(ERROR_SEARCHING_BED).append(bedNumber).toString();
			Logger.error(message, e);
			throw new ApplicationException(message);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateBed(Bed bed) throws ApplicationException {
		try {
			return super.update(bed);
		} catch (ApplicationException e) {
			String message = new StringBuilder().append(ERROR_UPDATING_BED).append(bed.getBedNumber()).toString();
			Logger.error(message, e);
			throw new ApplicationException(message);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Bed searchBedByVisit(Visit visit) throws ApplicationException {
		try {
			return super.getByAttribute(Bed.class, BedConstants.VISIT_LABEL, visit);
		} catch (ApplicationException e) {
			String message = new StringBuilder().append(ERROR_SEARCHING_BED_BY_VISIT).append(visit.getId()).toString();
			Logger.error(message, e);
			throw new ApplicationException(message);
		}
	}

}
