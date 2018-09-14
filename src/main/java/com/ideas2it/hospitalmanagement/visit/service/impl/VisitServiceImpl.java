package com.ideas2it.hospitalmanagement.visit.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.visit.dao.VisitDao;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * VisitServiceImpl is the Service class implementing the EmployeeService
 * interface and this implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to
 * do the data accessing operations.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class VisitServiceImpl implements VisitService {

    private VisitDao visitDao ;

    public void setVisitDao(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    /**
     * {@inheritDoc}
     */
    public boolean addVisit(final Visit visit)
            throws ApplicationException {
        return visitDao.insertVisit(visit);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyVisit(final Visit visit)
            throws ApplicationException {
        return visitDao.updateVisit(visit);
    }

    /**
     * {@inheritDoc}
     */
    public Visit getVisitById(final Integer visitId)
            throws ApplicationException {
        return visitDao.searchVisitById(visitId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Visit> getVisits()
            throws ApplicationException {
        return visitDao.getAllVisits();
    }

	/**
	 *  {@inheritDoc}
	 */
	public List<Visit> retrieveVisitsByIds(Integer[] ids) throws ApplicationException {
		return visitDao.getVisitsByIds(ids);
	}
}