package com.ideas2it.hospitalmanagement.bed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.utils.DateUtil;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.bed.service.impl.BedServiceImpl;
import com.ideas2it.hospitalmanagement.bedallocation.model.BedAllocation;

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
     * @param bedNumber 						Bed Number
     * @param visitId							Visit Id
     * 
     * @return ModelAndView 					Used for displaying the view for the 
     *                               			application user.
     */
	@RequestMapping(value="/admitPatient" , method= RequestMethod.POST)   
    public ModelAndView admitPatient(@RequestParam("bedNumber") 
          int bedNumber,	@RequestParam("visitId") int visitId) {
        ModelAndView modelAndView = new ModelAndView("nurseHome");
        ModelAndView mav = new ModelAndView("nurseHome");
		try {
			bedService.admitPatient(visitId, bedNumber);
			mav.addObject("inpatients", bedService.getVisitsByPatientType("InPatient"));
		} catch(ApplicationException e) {
			  
		}
		  return mav;
    }
    

	@RequestMapping(value="/vacatePatient" , method= RequestMethod.POST)   
    public ModelAndView vacatePatient(@RequestParam("visitId") int visitId) {
        ModelAndView mav = new ModelAndView("nurseHome");
		try {
			Visit visit = bedService.searchvisitByNumber(visitId);
	   
			mav.addObject("inpatients", bedService.getVisitsByPatientType("InPatient"));
		} catch(ApplicationException e) {
			  
		}
		  return mav;
    }
	
	
	  @RequestMapping(value="/dischargeButton", method=RequestMethod.POST)
	    public ModelAndView dischargeButton(@RequestParam("visitId")String visitId) {
	        ModelAndView mav = new ModelAndView("nurseHome");
	  	  try {

				Visit visit = bedService.searchvisitByNumber(Integer.parseInt(visitId));
System.out.println("visitIDddddddddddddddddddd" + visit.getId());
				Bed bed= bedService.searchBedByVisit(visit);
		  	  	 System.out.println("visitIdddsdsdsdsdssds"  + bed.getBedNumber());
                bedService.dischargePatient(bed.getBedNumber());
				mav.addObject("inpatients", bedService.getVisitsByPatientType("InPatient"));


	        } catch(ApplicationException e) {
	      	  
	        }
	  	  return mav;
	  	  
	    }
	    
	
	/**
     * <p>
     * dischargePatient method is used to discharge a patient from his assigned
     * bed
     * </p>
     * @param bedNumber 						Bed Number
     * @param visitId							Visit Id
     * 
     * @return ModelAndView 					Used for displaying the view for the 
     *                               			application user.
     */
    @RequestMapping(value="/dischargePatient" , method= RequestMethod.POST)   
    public ModelAndView dischargePatient(@RequestParam("bedNumber") 
        	int bedNumber) {        
        ModelAndView mav = new ModelAndView("nurseHome");
		try {
			bedService.dischargePatient(bedNumber);
			mav.addObject("inpatients", bedService.getVisitsByPatientType("InPatient"));
		} catch(ApplicationException e) {
			  
		}
		  return mav;
    }

    
 

    
    /**
     * <p>
     * makeBedAvailable method is used to make the bed available for occupying
     * after completing it's maintanence
     * </p>
     * @param bedNumber 						Bed Number
     * 
     * @return ModelAndView 					Used for displaying the view for the 
     *                               			application user.
     */
    @RequestMapping(value="/makeBedAvailable" , method= RequestMethod.POST)   
    public ModelAndView makeBedAvailable(@RequestParam("bedNumber") int bedNumber) {
    	
        ModelAndView modelAndView = new ModelAndView("");
        try {
        	Bed bed = bedService.searchBedByNumber(bedNumber);
        	bed.setStatus("Available");
        	if(bedService.updateBed(bed)){
        		//Success message
        	} else {
        		//Fail message
        	}
        	return modelAndView;
        } catch (ApplicationException e) {
        	//Attach an exception message for model.
        	return modelAndView;
		}
    }
    
    public List<Integer> getWardIds() throws ApplicationException {
        List<Integer> wardIds = new ArrayList<Integer>();
        for(Ward wardIterator : bedService.getWardsByStatus("All")) {
        	wardIds.add(wardIterator.getWardNumber());
        }
        return wardIds;
    }
    /**
     * <p>
     * performBedMaintanence method is used to perform maintenance over a particular bed.
     * </p>
     * @param bedNumber 						Bed Number
     * 
     * @return ModelAndView 					Used for displaying the view for the 
     *                               			application user.
     */ 
    @RequestMapping(value="/performBedMaintanence" , method= RequestMethod.POST)   
    public ModelAndView performBedMaintanence(@RequestParam("bedNumber") int bedNumber) {
    	
        ModelAndView modelAndView = new ModelAndView("");
        try {
        	Bed bed = bedService.searchBedByNumber(bedNumber);
        	bed.setStatus("Under Maintanence");
        	if(bedService.updateBed(bed)){
        		//Success message
        	} else {
        		//Fail message
        	}
        	return modelAndView;
        } catch (ApplicationException e) {
        	//Attach an exception message for model.
        	return modelAndView;
		}
    } 
}