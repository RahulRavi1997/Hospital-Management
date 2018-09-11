package com.ideas2it.hospitalmanagement.bed.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

public class BedController {
	
	   private static BedService bedService;

	    public  void setBedService(BedService bedService) {
	        this.bedService = bedService;

	    }

	   @RequestMapping(value = "/assignBed", method = RequestMethod.POST)
	   public  ModelAndView assignBed(@ModelAttribute("Bed") Bed bed, @RequestParam("visitId") int visitId)  { 
		   try {
               ModelAndView mav = new ModelAndView("AssignBed.jsp");
		       bed.setVisitId(visitId);
		       bedService.updateBed(bed);
               mav.addObject("beds" , bedService.retrieveBeds());
               return mav;
	       } catch (ApplicationException e) {
	    	
	       }
	
}
