package com.ideas2it.hospitalmanagement.visit.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Query;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.visit.dao.VisitDao;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

/**
 * VisitDaoImpl is the dao class implements the VisitDao interface and
 * it is processing all the interface methods and this class is having its own
 * method to fetch the ProjectDetails of the Visit.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove,
 * Search and Display the details in the Database implements the VisitDao
 * interface functions.
 * </p>
 * ArrayList is used to store the values of the Visit details which are
 * gathered from the Database.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class VisitDaoImpl extends GenericDao implements VisitDao {

    public VisitDaoImpl() throws ApplicationException {
		super();
	}

	String VISIT_IN_QUERY = "from Visit where id in (:ids)";
	String IDS = "ids";
	String PATIENT_VISIT_IN_QUERY = "from Visit where PATIENT = :id and ADMIT_DATE = :date";
	String ID = "id";
	String DATE = "date";


	/**
	 * {@inheritDoc}
	 */
	public boolean insertVisit(Visit visit) throws ApplicationException {

		try {
			return (null != super.save(visit));
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.
					VISIT_ADDITION_EXCEPTION, visit.getPatient(), visit.getPhysician()), e);
			throw new ApplicationException(String.format(Constants.
					VISIT_ADDITION_EXCEPTION, visit.getPatient(), visit.getPhysician()), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateVisit(Visit visit) throws ApplicationException {

		try {
			return super.update(visit);
		} catch (ApplicationException e) {
			Logger.error(String.format(
					Constants.VISIT_EDIT_EXCEPTION, visit.getId()), e);
			throw new ApplicationException(String.format(
					Constants.VISIT_EDIT_EXCEPTION, visit.getId()), e);
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	public Visit searchVisitById(Integer visitId) throws ApplicationException {

		try {
			return super.get(Visit.class, visitId);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.VISIT_SEARCH_EXCEPTION, visitId), e);
			throw new ApplicationException(String.format(Constants.VISIT_SEARCH_EXCEPTION,
					visitId));
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	public List<Visit> getAllVisits() throws ApplicationException {

		try {
			return super.getAll(Visit.class);
		} catch (ApplicationException e) {
			Logger.error(Constants.VISIT_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.VISIT_DISPLAY_EXCEPTION, e);
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	public List<Visit> getVisitsByIds(Integer[] ids) throws ApplicationException {

		try {
			Session session = super.getSession();
			Query query = session.createQuery(VISIT_IN_QUERY);  
			query.setParameterList(IDS, ids); 
			return query.list();
		} catch (ApplicationException e) {
			Logger.error(Constants.VISIT_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.VISIT_DISPLAY_EXCEPTION, e);
		}
	}
	
    /**
     * <p>
     * Method to search the visit Id in the database.This method is using
     * the visitId to search the visit and is searched in the database.
     * </p>
     *
     * @param   visitId  a int datatype which contains the visit
     *                      id that needs to be searched.
     * @return  visit    returns visit object when id is found
     *                      and null when not found.
     */
    public Visit searchVisitByPatientId(final Integer patientId)
            throws ApplicationException {
		try {
			Session session = super.getSession();
			Query query = session.createQuery(PATIENT_VISIT_IN_QUERY);  
			query.setParameter(ID, patientId);
			query.setParameter(DATE,java.time.LocalDate.now());

			return (Visit) query.uniqueResult();
		} catch (ApplicationException e) {
			Logger.error(Constants.VISIT_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.VISIT_DISPLAY_EXCEPTION, e);
		}
    }
}