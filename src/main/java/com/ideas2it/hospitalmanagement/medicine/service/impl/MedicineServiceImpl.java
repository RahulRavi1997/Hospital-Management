package com.ideas2it.hospitalmanagement.medicine.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.medicine.dao.MedicineDao;
import com.ideas2it.hospitalmanagement.medicine.dao.impl.MedicineDaoImpl;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.medicine.model.Medicine;
import com.ideas2it.hospitalmanagement.medicine.service.MedicineService;

/**
 * <p>
 * This class is used to manipulate and perform business logic operations with 
 * the Medicine details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class MedicineServiceImpl implements MedicineService {
	
	public MedicineServiceImpl() throws ApplicationException {
		super();
	}
	
    private MedicineDao medicineDao = new MedicineDaoImpl();
  
    /**
     * @{inheritdoc}
     */
    public boolean addMedicine(Medicine medicine) throws ApplicationException {
        return medicineDao.insertMedicine(medicine);
    }

    /**
     * @{inheritdoc}
     */
    public List<Medicine> retrieveMedicines() throws ApplicationException {
        return medicineDao.getAllMedicines();
    }
    
    /**
     * @{inheritdoc}
     */
    public boolean deleteMedicine(Medicine medicine) throws ApplicationException {
        return medicineDao.deleteMedicine(medicine);
    }

    /**
     * @{inheritdoc}
     */
    public boolean updateMedicine(Medicine medicine) throws ApplicationException {
        return medicineDao.updateMedicine(medicine);
    }
    
    /**
     * @{inheritdoc}
     */
    public Medicine searchMedicine(int medicineId) throws ApplicationException {
        return medicineDao.searchMedicine(medicineId);
    }
    
    /**
	 *  {@inheritDoc}
	 */
	public boolean restoreMedicine(int id) throws ApplicationException {
		Medicine medicine = searchMedicine(id);
		if(null == medicine) {
			return Boolean.FALSE;
		}
		return medicineDao.restoreMedicine(medicine);
	}

    /**
     *  {@inheritDoc}
     */
    public List<Medicine> retrieveMedicinesByName(String name) throws ApplicationException {
	    return medicineDao.getMedicinesByName(name);
    }

}
