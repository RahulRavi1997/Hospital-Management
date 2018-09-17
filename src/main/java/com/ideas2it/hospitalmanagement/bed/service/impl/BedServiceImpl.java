package com.ideas2it.hospitalmanagement.bed.service.impl;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.bedallocation.model.BedAllocation;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.utils.DateUtil;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;
import com.ideas2it.hospitalmanagement.visit.service.impl.VisitServiceImpl;

import java.util.Date;

import com.ideas2it.hospitalmanagement.bed.dao.BedDao;
import com.ideas2it.hospitalmanagement.bed.dao.impl.BedDaoImpl;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

public class BedServiceImpl extends GenericDao implements BedService {
	
	private static BedDao bedDao;
	private static VisitService visitService;
	
    public static BedDao getBedDao() {
		return bedDao;
	}

	public static void setBedDao(BedDaoImpl bedDao) {
		BedServiceImpl.bedDao = bedDao;
	}
	
	public static VisitService getVisitService() {
		return visitService;
	}

	public static void setVisitService(VisitServiceImpl visitService) {
		BedServiceImpl.visitService = visitService;
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean admitPatient(int visitId, int bedNumber) throws ApplicationException {
		Bed bed = searchBedByNumber(bedNumber);
	//	if(bed.getStatus() != "Occupied") {
		//	Visit visit = visitService.getVisitById(visitId);
			//if(visit.getPatientType() == "InPatient") {
				bed.setVisitId(visitId);
				bed.setStatus("Occupied");
        		addBedAllocationDetails(visitId, bed);
				return bedDao.updateBed(bed);
		//	} else {
			//	return false;
			///}
		//} else {
			//return false;
		//}
	}
	
	
    private void addBedAllocationDetails(int visitId, Bed bed) {
System.out.println("hellooooooooooooooooooo wrold" + visitId + "bedddddddddddddddddddd" + bed);
    	BedAllocation bedAllocation = new BedAllocation();
    	bedAllocation.setBed(bed);
    	bedAllocation.setVisitId(visitId);
    	try {
			bedAllocation.setAdmitDate(DateUtil.getCurrentDate());
			bed.getBedAllocations().add(bedAllocation);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
		}
	}

	
	/**
	 *  {@inheritDoc}
	 */
	public Bed searchBedByNumber(int bedNumber) throws ApplicationException {
		return bedDao.searchBedByNumber(bedNumber);
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public boolean dischargePatient(int visitId, int bedNumber) throws ApplicationException {
		Bed bed = searchBedByNumber(bedNumber);
		if(bed.getStatus() == "Occupied") {
			Visit visit = visitService.getVisitById(visitId);
			if(visit.getPatientType() == "OutPatient" && null == visit.getDischargeDate()) {
				visit.setDischargeDate(new Date());
				bed.setVisitId(null);
				bed.setStatus("Under Maintainence");
        		addBedDischargeDetails(visitId, bed);
				visitService.modifyVisit(visit);
				return bedDao.updateBed(bed);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private void addBedDischargeDetails(int visitId, Bed bed) {
        for(BedAllocation bedAllocation : bed.getBedAllocations()) {
        	if(bedAllocation.getVisitId() == visitId) {
        		try {
					bedAllocation.setDischargeDate(DateUtil.getCurrentDate());
				} catch (ApplicationException e) {
					
					
				}
        		
        	}
        }
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean updateBed(Bed bed) throws ApplicationException {
		return bedDao.updateBed(bed);
	}
}