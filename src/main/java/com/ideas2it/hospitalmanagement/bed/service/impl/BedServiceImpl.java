package com.ideas2it.hospitalmanagement.bed.service.impl;

import java.util.Date;
import java.util.List;

import com.ideas2it.hospitalmanagement.bed.commons.constants.BedConstants;
import com.ideas2it.hospitalmanagement.bed.dao.BedDao;
import com.ideas2it.hospitalmanagement.bed.dao.impl.BedDaoImpl;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.bedallocation.model.BedAllocation;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.utils.DateUtil;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;
import com.ideas2it.hospitalmanagement.visit.service.impl.VisitServiceImpl;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.service.WardService;

/**
 * BedServiceImpl is the Service class implementing the BedService interface and this
 * implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to do the data accessing
 * operations.
 * </p>
 *
 * @author latheesh
 * @version 1.0
 */
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

	public static void setBedDao(BedDaoImpl bedDao) {
		BedServiceImpl.bedDao = bedDao;
	}

	public static void setVisitService(VisitServiceImpl visitService) {
		BedServiceImpl.visitService = visitService;
	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean admitPatient(int visitId, int bedNumber) throws ApplicationException {
		Bed bed = searchBedByNumber(bedNumber);
		if(bed.getStatus() != BedConstants.OCCUPIED) {
			Visit visit = visitService.getVisitById(visitId);
			if(visit.getPatientType().equals(BedConstants.INPATIENT) 
					&& bed.getStatus().equals(BedConstants.AVAILABLE)) {
				bed.setVisit(visit);
				bed.setStatus(BedConstants.OCCUPIED);
				visit.setPatientStatus(BedConstants.ADMITTED);
		    	visit.setDischargeDate(null);
				visitService.modifyVisit(visit,visit.getPatient().getId(),visit.getPhysician().getId());
        		addBedAllocationDetails(visit, bed);
			    return bedDao.updateBed(bed);
			} else {
				return Boolean.FALSE;
			}
		} else {
			return Boolean.FALSE;
		}
	}
	
    /**
     * Allows to create the bed allocation  details with the admit date and
     * all the necessary details.	
     * 
     * @param visit Visit Information
     * 
     * @param bed   Bed Informataion
     */
    private void addBedAllocationDetails(Visit visit, Bed bed) {
    	BedAllocation bedAllocation = new BedAllocation();
    	bedAllocation.setBed(bed);
    	bedAllocation.setVisit(visit);
    	try {
			bedAllocation.setAdmitDate(DateUtil.getCurrentDate());
			bed.getBedAllocations().add(bedAllocation);
		} catch (ApplicationException e) {
			Logger.error((new StringBuilder().append(BedConstants.VISIT).
					append(visit.getId()).
					append(BedConstants.BED_NOT_ASSIGNED).
					append(bed.getBedNumber())).toString(),e);
		}
	}
 
    /**
     * {@inheritDoc}
     */
	public List<Ward> displayAllWards(String status) throws ApplicationException{
	    return wardService.displayAllWards(BedConstants.ALL);
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
	public Visit searchvisitByNumber(int visitId) throws ApplicationException {
		return visitService.getVisitById(visitId);
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public Bed searchBedByVisit(Visit visit) throws ApplicationException {
		return bedDao.searchBedByVisit(visit);
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public boolean dischargePatient(int bedNumber) throws ApplicationException {

		Bed bed = searchBedByNumber(bedNumber);

		if(bed.getStatus().equals(BedConstants.OCCUPIED)) {
			Visit visit = bed.getVisit();
			if(visit.getPatientType().equals(BedConstants.INPATIENT)) {
				visit.setDischargeDate(new Date());
				bed.setStatus(BedConstants.AVAILABLE);
				visit.setPatientStatus(BedConstants.DISCHARGED);
        		addBedDischargeDetails(bed.getVisit(), bed);
				visitService.modifyVisit(visit,visit.getPatient().getId(),visit.getPhysician().getId());
				return bedDao.updateBed(bed);
			} else {
				return Boolean.FALSE;
			}
		} else {
			return Boolean.FALSE;
		}
	}
	
    /**
     * {@inheritDoc}
     */
	private void addBedDischargeDetails(Visit visit, Bed bed) {
		bed.setVisit(null);
        for(BedAllocation bedAllocation : bed.getBedAllocations()) {
        	if(bedAllocation.getVisit() != null) {
        		try {
					bedAllocation.setDischargeDate(DateUtil.getCurrentDate());
				} catch (ApplicationException e) {
					Logger.error((new StringBuilder().
							append(BedConstants.VISIT).
							append(visit.getId()).
							append(BedConstants.BED_NOT_DISCHARGED).
					        append(bed.getBedNumber())).toString(),e);				
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
