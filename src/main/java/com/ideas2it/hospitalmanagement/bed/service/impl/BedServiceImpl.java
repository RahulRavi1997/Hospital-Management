package com.ideas2it.hospitalmanagement.bed.service.impl;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.bedallocation.model.BedAllocation;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.utils.DateUtil;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;
import com.ideas2it.hospitalmanagement.visit.service.impl.VisitServiceImpl;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.service.WardService;

import java.util.Date;
import java.util.List;

import com.ideas2it.hospitalmanagement.bed.dao.BedDao;
import com.ideas2it.hospitalmanagement.bed.dao.impl.BedDaoImpl;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

public class BedServiceImpl extends GenericDao implements BedService {
	
	private static BedDao bedDao;
	private static VisitService visitService;
	private static WardService wardService;
	
	public static WardService getWardService() {
		return wardService;
	}

	public static void setWardService(WardService wardService) {
		BedServiceImpl.wardService = wardService;
	}

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
		if(bed.getStatus() != "Occupied") {
			Visit visit = visitService.getVisitById(visitId);
			if(visit.getPatientType().equals("InPatient") && bed.getStatus().equals("Available")) {
				bed.setVisit(visit);
				bed.setStatus("Occupied");
				System.out.println("hellooooooooooooooooooooooooooooooooooooooooooooo" + 
						visit.getId() + "" + visit.getPatientStatus());

				visit.setPatientStatus("Admitted");
				visitService.modifyVisit(visit);

				System.out.println("dddddddddddddddddddddddddddddddddd" + visit.getPatientStatus());
        		addBedAllocationDetails(visit, bed);
				return bedDao.updateBed(bed);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
    private void addBedAllocationDetails(Visit visit, Bed bed) {
    	BedAllocation bedAllocation = new BedAllocation();
    	bedAllocation.setBed(bed);
    	bedAllocation.setVisit(visit);
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
	
	public Visit searchvisitByNumber(int visitId) throws ApplicationException {
		return visitService.getVisitById(visitId);
	}
	
	public Bed searchBedByVisit(Visit visit) throws ApplicationException {
		return bedDao.searchBedByVisit(visit);
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public boolean dischargePatient(int bedNumber) throws ApplicationException {

		Bed bed = searchBedByNumber(bedNumber);

		if(bed.getStatus().equals("Occupied")) {

			Visit visit = bed.getVisit();
			if(visit.getPatientType().equals("InPatient")) {
				visit.setDischargeDate(new Date());
				bed.setStatus("Available");
        	
				visit.setPatientStatus("Yet to Admit");
        		addBedDischargeDetails(bed.getVisit(), bed);
				visitService.modifyVisit(visit);
				return bedDao.updateBed(bed);
			} else {
        		System.out.println("falseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

				return false;
			}
			} else {
			return false;
		}
	}
	
	private void addBedDischargeDetails(Visit visit, Bed bed) {
		bed.setVisit(null);
        for(BedAllocation bedAllocation : bed.getBedAllocations()) {
        	if(bedAllocation.getVisit() != null) {
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
	public List<Ward> getWardsByStatus(String status) throws ApplicationException {
		return wardService.displayAllWards(status);
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public boolean updateBed(Bed bed) throws ApplicationException {
		return bedDao.updateBed(bed);
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public List<Visit> getVisitsByPatientType(String status)throws ApplicationException{
		return visitService.getVisitsByPatientType(status);
	}
}