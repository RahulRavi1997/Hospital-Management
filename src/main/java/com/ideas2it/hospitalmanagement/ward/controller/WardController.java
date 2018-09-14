package com.ideas2it.hospitalmanagement.ward.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.service.WardService;

@Controller
public class WardController {
	
	private static WardService wardService;
	


    public  void setWardService(WardService wardService) {
        this.wardService = wardService;
    }



    @RequestMapping(value = "/AddWard", method = RequestMethod.GET)
    public ModelAndView showForm() {


        return new ModelAndView("Ward", "ward", new Ward());

    }


  @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="AddWard")
  public ModelAndView createWard(@ModelAttribute("ward") Ward ward ,
		   @RequestParam("noOfRooms")String noOfRooms) {
	  ModelAndView mav = new ModelAndView("a");
	  try {
        System.out.println("controllerwardname" + ward.getName() + "" + noOfRooms);
        wardService.createWard(ward, Integer.parseInt(noOfRooms));
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
  }

  
  @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="ChangeWardToMaintaince")
  public ModelAndView ChangeWardToMaintaince(@ModelAttribute("ward") Ward ward) {
	  
	 ModelAndView mav = new ModelAndView("a");
	  try {
      	wardService.deleteWard(wardService.searchWard(ward.getWardNumber()));
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
  
  @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="ChangeWardToFree")
	  public ModelAndView ChangeWardToFree(@RequestParam("number")String wardnumber) {
		  Ward ward = new Ward();
		 ModelAndView mav = new ModelAndView("a");
		  try {
	      ward = 	wardService.searchWard(Integer.parseInt(wardnumber));
     		wardService.changeWardToFree(ward);
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
  
  
  @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="AddRoomsToWard")
  public ModelAndView addRoomsToWard(@RequestParam("number")String wardnumber,
		  @RequestParam("NoOfRooms")String noOfRooms) {
	  Ward ward = new Ward();
	  System.out.println("wwwwwwwwwwwwwwwww" + noOfRooms + "" + wardnumber);
	 ModelAndView mav = new ModelAndView("a");
	  try {
      ward = 	wardService.searchWard(Integer.parseInt(wardnumber));
      wardService.addRoomsToWard(ward, Integer.parseInt(noOfRooms));

      mav.addObject("ward" , ward);
      System.out.println("rooms in ward" + ward);
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
  
  @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="SearchWard")
  public ModelAndView SearchWard(@RequestParam("number")String wardnumber) {
	  Ward ward = new Ward();
	  System.out.println("wwwwwwwwwwwwwwwww" + wardnumber);
	 ModelAndView mav = new ModelAndView("a");
	  try {
      ward = 	wardService.searchWard(Integer.parseInt(wardnumber));
      mav.addObject("ward" , ward);
      System.out.println("rooms in ward" + ward);
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
    
    public void updateWard() {
    	Ward ward = new Ward();
    	int numberOfRooms = 0;
    	try {
        	wardService.updateWard(ward);
    	}catch (ApplicationException e) {
    		
    	}

    }
    
    public void addRooms() {
    	Ward ward = new Ward();
    	int numberOfRooms = 0;
    	int wardNumber = 0;

    	try {
        	wardService.addRooms(wardService.searchWard(wardNumber), numberOfRooms);
    	}catch (ApplicationException e) {
    		
    	}

    }
    
    public void deleteWard() {
    	Ward ward = new Ward();
    	int wardNumber = 0;
    	try {
        	wardService.deleteWard(wardService.searchWard(wardNumber));
    	}catch (ApplicationException e) {
    		
    	}

    }
    
    public void  searchWard() {
    	Ward ward = new Ward();
    	int wardNumber = 0;
    	try {
        	wardService.searchWard(wardNumber);
    	}catch (ApplicationException e) {
    		
    	}

    }
    
    public void retrieveAllWards() {
    	String status = null;
    	try {
        	wardService.displayAllWards(status);
    	}catch (ApplicationException e) {
    		
    	}
	
    }
    
}
