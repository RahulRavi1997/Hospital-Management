package com.ideas2it.hospitalmanagement.medicine.dao.impl;

import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.medicine.dao.MedicineDao;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.medicine.model.Medicine;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;

/**
 * <p>
 * This is a Data-Access-Object Class for executing data manipulation
 * operation on Medicine data such as add, update, remove and search.
 * on Medicine details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class MedicineDaoImpl extends GenericDao implements MedicineDao {
	
	public MedicineDaoImpl() throws ApplicationException {
		super();
	}

    String MEDICINES_IN_NAMES = "from Medicine where name like :name";
    String NAME = "name";
	
    /**
     * {@inheritDoc}
     */
    public boolean insertMedicine(Medicine medicine) throws ApplicationException {
		medicine.setActive(Boolean.TRUE);
        try {
			return (null != super.save(medicine));
        } catch (ApplicationException e) {
            Logger.error(String.format
                (Constants.MEDICINE_ADDITION_EXCEPTION, medicine.getId()), e);
            throw new ApplicationException(String.format
                (Constants.MEDICINE_ADDITION_EXCEPTION, medicine.getId()), e);            
        }
    } 

    /**
     * {@inheritDoc}
     */
    public boolean updateMedicine(Medicine medicine) throws ApplicationException {      
        try {
			return super.update(medicine);
        } catch (ApplicationException e) {
            Logger.error(String.format
                (Constants.MEDICINE_UPDATE_EXCEPTION, medicine.getId()), e);
            throw new ApplicationException(String.format
                (Constants.MEDICINE_UPDATE_EXCEPTION, medicine.getId()), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteMedicine(Medicine medicine) throws ApplicationException {
    	medicine.setActive(Boolean.FALSE);
		return updateMedicine(medicine);
    }

    /**
     * {@inheritDoc}
     */
    public List<Medicine> getAllMedicines() throws ApplicationException {
        try {
			return super.getAll(Medicine.class);
        } catch (ApplicationException e) {
            Logger.error(e);
            throw new ApplicationException(e);
        } 
    }

    /**
     * @{inheritdoc}
     */
    public Medicine searchMedicine(int medicineId) throws ApplicationException {      
        try {
			return super.get(Medicine.class, medicineId);
        } catch (ApplicationException e) {
            Logger.error(String.format
                (Constants.MEDICINE_SEARCH_EXCEPTION, medicineId), e);
            throw new ApplicationException(String.format
                (Constants.MEDICINE_SEARCH_EXCEPTION, medicineId), e);
        }
    }
    
    /**
	 *  {@inheritDoc}
	 */
	public boolean restoreMedicine(Medicine medicine)
			throws ApplicationException {
		medicine.setActive(Boolean.TRUE);
		return updateMedicine(medicine);
	}

    public List<Medicine> getMedicinesByName(String name) throws ApplicationException {
	    try {
			Session session = super.getSession();
			Query query = session.createQuery(MEDICINES_IN_NAMES);
			query.setParameter(NAME, name+"%");
			return query.list();
		} catch (ApplicationException e) {
            Logger.error(Constants.MEDICINE_DISPLAY_EXCEPTION, e);
			throw new ApplicationException(Constants.MEDICINE_DISPLAY_EXCEPTION, e);
		}
	}
}
