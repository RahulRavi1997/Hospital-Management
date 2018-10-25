package com.ideas2it.hospitalmanagement.bed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.bed.commons.constants.BedConstants;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.bed.service.impl.BedServiceImpl;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.ward.commons.constants.WardConstants;
import com.ideas2it.hospitalmanagement.ward.model.Ward;

/**
 * BedController is the controller class for the bed details, which allows the
 * application to execute the data manipulation operations of the bed related
 * Details.
 * <p>
 * The Operations that can be done using this application are Adding a bed
 * allocation Details, Modifying the bed allocation Details, Removing the bed
 * allocation Details, Searching for a bed related details and Displaying the
 * bed allocation Details.
 * </p>
 * The BedController class is mapped with Controller Annotation of Spring
 * Framework by which the Class is mapped to the Spring MVC.
 *
 * @author latheesh
 * @version 1.0
 */

@Controller
public class BedController {

	private static BedService bedService;

	public static BedService getBedService() {
		return bedService;
	}

	public static void setBedService(BedServiceImpl bedService) {
		BedController.bedService = bedService;
	}

	/**
	 * <p>
	 * admitPatient method is used to assign a particular patient to a particular
	 * bed
	 * </p>
	 * 
	 * @param bedNumber Bed Number to be searched
	 * @param visitId   Visit Id to be searched
	 * 
	 * @return ModelAndView Used for displaying the view for the application user.
	 */
	@RequestMapping(value = "/admitPatient", method = RequestMethod.POST)
	public ModelAndView admitPatient(@RequestParam(BedConstants.BEDNUMBER) int bedNumber,
			@RequestParam(BedConstants.VISITID) int visitId) {
		ModelAndView mav = new ModelAndView(BedConstants.NURSEHOME);
		try {
			if (bedService.admitPatient(visitId, bedNumber)) {
				mav.addObject(BedConstants.SUCCESS_MESSAGE, BedConstants.PATIENT_ADMITTED);
			} else {
				mav.addObject(BedConstants.FAIL_MESSAGE, BedConstants.PATIENT_NOT_ADMITTED);
			}
			mav.addObject(BedConstants.INPATIENTS, bedService.getVisitsByPatientType(BedConstants.INPATIENT));
		} catch (ApplicationException e) {
			mav.addObject(BedConstants.FAIL_MESSAGE, e);
		}
		return mav;
	}

	/**
	 * <p>
	 * vacatePatient method is used to vacate a particular patient to a particular
	 * bed
	 * </p>
	 * 
	 * @param bedNumber Bed Number to be searched
	 * @param visitId   Visit Id to be searched
	 * 
	 * @return ModelAndView Used for displaying the view for the application user.
	 */
	@RequestMapping(value = "/vacatePatient", method = RequestMethod.POST)
	public ModelAndView vacatePatient(@RequestParam(BedConstants.VISITID) String visitId) {
		ModelAndView mav = new ModelAndView(WardConstants.DISPLAYWARDS);
		try {
			Visit visit = bedService.searchvisitByNumber(Integer.parseInt(visitId));
			Bed bed = bedService.searchBedByVisit(visit);
			bedService.dischargePatient(bed.getBedNumber());
			mav.addObject(BedConstants.VISITID, visitId);
			mav.addObject(WardConstants.ADMITBUTTON, WardConstants.YES);
			mav.addObject(WardConstants.WARDS, bedService.displayAllWards(WardConstants.ALL));
			mav.addObject(WardConstants.WARD, new Ward());
			mav.addObject(WardConstants.WARDIDS, getWardIds());
		} catch (ApplicationException e) {
			mav.addObject(BedConstants.FAIL_MESSAGE, e);
		}
		return mav;
	}

	/**
	 * <p>
	 * dischargeButton method is used to discharge a patient from his bed given his
	 * visitId
	 * </p>
	 * 
	 * 
	 * 
	 * @param visitId Visit Id to be searched
	 * 
	 * 
	 * @return ModelAndView Used for displaying the view for the application user.
	 */
	@RequestMapping(value = "/dischargeButton", method = RequestMethod.POST)
	public ModelAndView dischargeButton(@RequestParam(BedConstants.VISITID) String visitId) {
		ModelAndView mav = new ModelAndView(BedConstants.NURSEHOME);
		try {
			Visit visit = bedService.searchvisitByNumber(Integer.parseInt(visitId));
			Bed bed = bedService.searchBedByVisit(visit);
			bedService.dischargePatient(bed.getBedNumber());
			mav.addObject(BedConstants.INPATIENTS, bedService.getVisitsByPatientType(BedConstants.INPATIENT));
		} catch (ApplicationException e) {
			mav.addObject(BedConstants.FAIL_MESSAGE, e);
		}
		return mav;
	}

	/**
	 * <p>
	 * dischargePatient method is used to discharge a patient from his assigned bed
	 * </p>
	 * 
	 * 
	 * @param bedNumber Bed Number to be searched for discharging
	 * @param visitId   Visit Id to be searched
	 * 
	 * 
	 * 
	 * @return ModelAndView Used for displaying the view for the application user.
	 */
	@RequestMapping(value = "/dischargePatient", method = RequestMethod.POST)
	public ModelAndView dischargePatient(@RequestParam(BedConstants.BEDNUMBER) int bedNumber) {
		ModelAndView mav = new ModelAndView(BedConstants.NURSEHOME);
		try {
			if (bedService.dischargePatient(bedNumber)) {
				mav.addObject(BedConstants.SUCCESS_MESSAGE, BedConstants.PATIENT_DISCHARGED);
			} else {
				mav.addObject(BedConstants.FAIL_MESSAGE, BedConstants.PATIENT_NOT_DISCHARGED);
			}
			mav.addObject(BedConstants.INPATIENTS, bedService.getVisitsByPatientType(BedConstants.INPATIENT));
		} catch (ApplicationException e) {
			mav.addObject(BedConstants.FAIL_MESSAGE, e);
		}
		return mav;
	}

	/**
	 * <p>
	 * makeBedAvailable method is used to make the bed available for occupying after
	 * completing it's maintenance
	 * </p>
	 * 
	 * 
	 * @param bedNumber Bed Number to be searched
	 * 
	 * @return ModelAndView Used for displaying the view for the application user.
	 */
	@RequestMapping(value = "/makeBedAvailable", method = RequestMethod.POST)
	public ModelAndView makeBedAvailable(@RequestParam(BedConstants.BEDNUMBER) int bedNumber) {
		ModelAndView modelAndView = new ModelAndView(BedConstants.NURSEHOME);
		try {
			modelAndView.addObject(BedConstants.INPATIENTS, bedService.getVisitsByPatientType(BedConstants.INPATIENT));
			Bed bed = bedService.searchBedByNumber(bedNumber);
			bed.setStatus(BedConstants.AVAILABLE);
			if (bedService.updateBed(bed)) {
				modelAndView.addObject(BedConstants.SUCCESS_MESSAGE, BedConstants.BED_FREED);
			} else {
				modelAndView.addObject(BedConstants.FAIL_MESSAGE, BedConstants.BED_NOT_FREED);
			}
		} catch (ApplicationException e) {
			modelAndView.addObject(BedConstants.FAIL_MESSAGE, e);
		}
		return modelAndView;
	}

	/**
	 * <p>
	 * getWardIds method is used to retrieve all the Ward Id's present
	 * </p>
	 * 
	 * @return List<Integer> List of ward id's
	 */
	public List<Integer> getWardIds() throws ApplicationException {
		List<Integer> wardIds = new ArrayList<Integer>();
		for (Ward wardIterator : bedService.getWardsByStatus(BedConstants.ALL)) {
			wardIds.add(wardIterator.getWardNumber());
		}
		return wardIds;
	}

	/**
	 * <p>
	 * performBedMaintanence method is used to perform maintenance over a particular
	 * bed.
	 * </p>
	 * 
	 * @param bedNumber Bed Number to be searched
	 * 
	 * @return ModelAndView Used for displaying the view for the application user.
	 */
	@RequestMapping(value = "/performBedMaintanence", method = RequestMethod.POST)
	public ModelAndView performBedMaintanence(@RequestParam(BedConstants.BEDNUMBER) int bedNumber) {

		ModelAndView modelAndView = new ModelAndView(BedConstants.NURSEHOME);
		try {
			Bed bed = bedService.searchBedByNumber(bedNumber);
			bed.setStatus(BedConstants.UNDER_MAINTANENCE);
			if (bedService.updateBed(bed)) {
				modelAndView.addObject(BedConstants.SUCCESS_MESSAGE, BedConstants.BEDMAINTAINCESUCESSMESSAGE);
			} else {
				modelAndView.addObject(BedConstants.FAIL_MESSAGE, BedConstants.BEDMAINTAINCEFAILUREMESSAGE);
			}
			return modelAndView;
		} catch (ApplicationException e) {
			modelAndView.addObject(BedConstants.FAIL_MESSAGE, e);
			return modelAndView;
		}
	}
}
