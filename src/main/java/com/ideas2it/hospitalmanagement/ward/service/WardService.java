package com.ideas2it.hospitalmanagement.ward.service;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.ward.model.Ward;

public interface WardService {
	
	public boolean createWard(Ward ward) throws ApplicationException;
	
	public boolean updateWard(Ward ward) throws ApplicationException;
	
	public Ward searchWard(Integer wardNumber) throws ApplicationException;
	
	
	
}