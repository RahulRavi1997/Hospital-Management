package com.ideas2it.hospitalmanagement.dosage.dao;

import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

public interface DosageDao {
	
	public int insertDosage(Dosage dosage) throws ApplicationException;
	
	public boolean updateDosage(Dosage dosage) throws ApplicationException;
	
	public Dosage searchDosage(int dosageId) throws ApplicationException;
}