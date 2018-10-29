package com.ideas2it.hospitalmanagement.visit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.visit.dao.VisitDao;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

/**
 * VisitDaoImpl is the dao class implements the VisitDao interface and it is processing all the
 * interface methods and this class is having its own method to fetch the ProjectDetails of the
 * Visit.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove, Search and Display the
 * details in the Database implements the VisitDao interface functions.
 * </p>
 * ArrayList is used to store the values of the Visit details which are gathered from the Database.
 *
 * @author Arul Murugan
 * @version 1.0
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
    public boolean insertVisit(final Visit visit) throws ApplicationException {

        try {
            return (null != super.save(visit));
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.VISIT_ADDITION_EXCEPTION, visit.getPatient(), visit.getPhysician()),
                    e);
            throw new ApplicationException(
                    String.format(Constants.VISIT_ADDITION_EXCEPTION, visit.getPatient(), visit.getPhysician()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateVisit(final Visit visit) throws ApplicationException {

        try {
            return super.update(visit);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.VISIT_EDIT_EXCEPTION, visit.getId()), e);
            throw new ApplicationException(String.format(Constants.VISIT_EDIT_EXCEPTION, visit.getId()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public Visit searchVisitById(final Integer visitId) throws ApplicationException {

        try {
            return super.get(Visit.class, visitId);
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.VISIT_SEARCH_EXCEPTION, visitId), e);
            throw new ApplicationException(String.format(Constants.VISIT_SEARCH_EXCEPTION, visitId),e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Visit> getAllVisits() throws ApplicationException {

        try {
            return super.getAll(Visit.class);
        } catch (final ApplicationException e) {
            throw new ApplicationException(Constants.VISIT_DISPLAY_EXCEPTION, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Visit> getVisitsByIds(final Integer[] ids) throws ApplicationException {

        Session session = null;
        try {
            session = super.getSession();
            final Query query = session.createQuery(VISIT_IN_QUERY);
            query.setParameterList(IDS, ids);
            return query.list();
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.VISIT_DISPLAY_EXCEPTION,ids), e);
            throw new ApplicationException(String.format(Constants.VISIT_DISPLAY_EXCEPTION,ids), e);
        } finally {
            GenericDao.close(session);
        }
    }
    
   /**
    *  {@inheritDoc}
    */
   public List<Visit> retrieveByPhysicianId(Integer physicianId) throws ApplicationException {
    try {
        final Session session = super.getSession();
        String sql = "SELECT id FROM visit where PHYSICIAN =" + physicianId;
        Query query = session.createSQLQuery(sql);
        List<Integer>  visitIds =  query.list();
        System.out.println(visitIds);
        int index = 0;
        Integer[] ids = new Integer[50];
        for (Object id : visitIds) {
            ids[index] = (Integer) id;
        }
        return getVisitsByIds(ids);

    } catch (final ApplicationException e) {
        Logger.error(String.format(Constants.VISIT_DISPLAY_EXCEPTION, physicianId), e);
        throw new ApplicationException(String.format(Constants.VISIT_DISPLAY_EXCEPTION, physicianId),e);
    }
   }
	/**
	 * {@inheritDoc}
	 */
	public List<Visit> getVisitsByPatientType(String patientType) throws ApplicationException {
		try {
            return super.getAll(Visit.class);
		} catch (ApplicationException e) {
			Logger.error(String.format(Constants.VISIT_DISPLAY_BY_PATIENT_TYPE,patientType), e);
			throw new ApplicationException(String.format(Constants.VISIT_DISPLAY_BY_PATIENT_TYPE,patientType), e);
		}
	}
    /**
     * {@inheritDoc}
     */
    public Visit searchVisitByPatientId(final Integer patientId) throws ApplicationException {
        Session session = null;
        try {
            session = super.getSession();
            final Query query = session.createQuery(PATIENT_VISIT_IN_QUERY);
            query.setParameter(ID, patientId);
            query.setParameter(DATE, java.time.LocalDate.now());
            return (Visit) query.uniqueResult();
        } catch (final ApplicationException e) {
            Logger.error(String.format(Constants.VISIT_DISPLAY_BY_PATIENT_ID_EXCEPTION,patientId), e);
            throw new ApplicationException(String.format(Constants.VISIT_DISPLAY_BY_PATIENT_ID_EXCEPTION,patientId), e);
        } finally {
            GenericDao.close(session);
        }
    }
}
