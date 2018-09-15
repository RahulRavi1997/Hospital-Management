package com.ideas2it.hospitalmanagement.ward.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.service.WardService;

@Controller
public class WardController {
	
	private static WardService wardService;
	


    public void setWardService(WardService wardService) {
        this.wardService = wardService;
    }



    @RequestMapping(value = "/AddWard", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("Ward", "ward", new Ward());

    }


    @RequestMapping(value = "/DisplayAllWards", method = RequestMethod.GET)
    public ModelAndView displayAllWards() {
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 ModelAndView mav = new ModelAndView("displayWards");
    	try {
        mav.addObject("wards" , wardService.displayAllWards("All"));
         mav.addObject("ward" , new Ward());
         mav.addObject("wardIds" , getWardIds());
    	} catch(ApplicationException e) {
    		
    	}
        return mav;

    }

    
  @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="AddWard")
  public ModelAndView createWard(@ModelAttribute("ward") Ward ward ,
		   @RequestParam("noOfRooms")String noOfRooms) {
		 ModelAndView mav = new ModelAndView("displayWards");
	  try {
        System.out.println("controllerwardname" + ward.getName() + "" + noOfRooms);
        wardService.createWard(ward, Integer.parseInt(noOfRooms));
        mav.addObject("wards" , wardService.displayAllWards("All"));
        mav.addObject("ward" , new Ward());
        mav.addObject("wardIds" , getWardIds());

      } catch(ApplicationException e) {
    	  
      }
	  return mav;
  }

  
  @RequestMapping(value="/ChangeWardToMaintaince", method=RequestMethod.POST)
  public ModelAndView ChangeWardToMaintaince(@ModelAttribute("ward") Ward ward) {
	  
	 ModelAndView mav = new ModelAndView("displayWards");
	  try {
      	wardService.deleteWard(wardService.searchWard(ward.getWardNumber()));
        mav.addObject("wards" , wardService.displayAllWards("All"));
        mav.addObject("ward" , new Ward());
        mav.addObject("wardIds" , getWardIds());

      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
  
  @RequestMapping(value="/ChangeWardToFree", method=RequestMethod.POST)
  public ModelAndView ChangeWardToFree(@RequestParam("number")String wardnumber) {
	  Ward ward = new Ward();
	  ModelAndView mav = new ModelAndView("displayWards");
		  try {
	        ward = wardService.searchWard(Integer.parseInt(wardnumber));
     		wardService.changeWardToFree(ward);
            mav.addObject("wards" , wardService.displayAllWards("All"));
            mav.addObject("ward" , new Ward());
            mav.addObject("wardIds" , getWardIds());
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
  
  public List<Integer> getWardIds() throws ApplicationException {
      List<Integer> wardIds = new ArrayList<Integer>();
      for(Ward wardIterator : wardService.displayAllWards("All")) {
      	wardIds.add(wardIterator.getWardNumber());
      }
      return wardIds;
  }
  
  @RequestMapping(value="/openAddMenu", method=RequestMethod.POST)
  public ModelAndView openAddRooms(@RequestParam("number")String wardnumber) {
	 ModelAndView mav = new ModelAndView("displayWards");
	  try {
        mav.addObject("wards" , wardService.displayAllWards("All"));
        mav.addObject("addRoomsToWard" , "Yes");
        mav.addObject("wardNumber" , Integer.parseInt(wardnumber));
        mav.addObject("ward" , new Ward());
        mav.addObject("wardIds" , getWardIds());
  } catch(ApplicationException e) {
	  
  }
  return mav;
}
  
  @RequestMapping(value="/searchWard", method=RequestMethod.POST)
  public ModelAndView searchWard(@RequestParam("wardNumber")String wardnumber) {
	 Ward ward = new Ward();
	 ModelAndView mav = new ModelAndView("searchWard");
	  try {
		ward = wardService.searchWard(Integer.parseInt(wardnumber));
        mav.addObject("wardNumber" , Integer.parseInt(wardnumber));
        mav.addObject("ward" , ward);
        mav.addObject("rooms", ward.getRooms());
  } catch(ApplicationException e) {
	  
  }
  return mav;
}
  public List<Integer> getRoomIds(Ward ward) throws ApplicationException{
	  List<Integer> roomIds = new ArrayList<Integer>();
	  for(Room room : ward.getRooms()) {
		  roomIds.add(room.getRoomNumber());
	  }
	  return roomIds;
  }
  
  @RequestMapping(value="/AddRooms", method=RequestMethod.POST)
  public ModelAndView addRoomsToWard(@RequestParam("wardNumber")String wardnumber,
		   @RequestParam("noOfRooms")String noOfRooms) {
	  Ward ward;
	 ModelAndView mav = new ModelAndView("displayWards");
	  try {
      ward = wardService.searchWard(Integer.parseInt(wardnumber));
      wardService.addRoomsToWard(ward, Integer.parseInt(noOfRooms));
      mav.addObject("wards" , wardService.displayAllWards("All"));
      mav.addObject("ward" , new Ward());
      mav.addObject("wardIds" , getWardIds());
      System.out.println("rooms in ward" + ward);
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
  
  @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="SearchWard")
  public ModelAndView SearchWard(@RequestParam("number")String wardnumber) {
	  Ward ward = new Ward();
	  System.out.println("wwwwwwwwwwwwwwwww" + wardnumber);
	 ModelAndView mav = new ModelAndView("displayWards");
	  try {
      ward = 	wardService.searchWard(Integer.parseInt(wardnumber));
      mav.addObject("wards" , wardService.displayAllWards("All"));
      mav.addObject("ward" , new Ward());
      mav.addObject("wardIds" , getWardIds());
      System.out.println("rooms in ward" + ward);
      } catch(ApplicationException e) {
    	  
      }
	  return mav;
	  
  }
    

    
}
