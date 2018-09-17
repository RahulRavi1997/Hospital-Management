package com.ideas2it.hospitalmanagement.bed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.utils.DateUtil;
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
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + bedNumber + "visit" + visitId);
        ModelAndView modelAndView = new ModelAndView("displayWards");
        try {
        	if(bedService.admitPatient(visitId, bedNumber)) {
        		modelAndView.addObject("wards",bedService.getWardsByStatus("All"));
        		modelAndView.addObject("wardIds" , getWardIds());
        	} else {
        		modelAndView.addObject("wards",bedService.getWardsByStatus("All"));
        		modelAndView.addObject("wardIds" , getWardIds());
        	}
        	modelAndView.addObject("ward" , new Ward());

        	return modelAndView;
        } catch (ApplicationException e) {
        	//Attach an exception message for model.
        	return modelAndView;
		} 
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
        	int bedNumber,	@RequestParam("visitId") int visitId) {

        try {
        	if(bedService.dischargePatient(visitId, bedNumber)) {
                ModelAndView modelAndView = new ModelAndView("displayWards");

        		modelAndView.addObject("ward" , new Ward());
        		modelAndView.addObject("wards",bedService.getWardsByStatus("All"));
        		modelAndView.addObject("wardIds" , getWardIds());
            	return modelAndView;
            	} else {
            	       ModelAndView modelAndView = new ModelAndView("displayWards");

            		modelAndView.addObject("ward" , new Ward());
            		modelAndView.addObject("wards",bedService.getWardsByStatus("All"));
            		modelAndView.addObject("wardIds" , getWardIds());
                	return modelAndView;     
                	}
        	
        } catch (ApplicationException e) {
        	ModelAndView modelAndView = null;
			//Attach an exception message for model.
        	return modelAndView;     

		} 
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