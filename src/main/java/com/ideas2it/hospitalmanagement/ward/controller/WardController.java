package com.ideas2it.hospitalmanagement.ward.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.ward.commons.constants.WardConstants;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.service.WardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WardController {
	
	private static WardService wardService;
	
    public void setWardService(WardService wardService) {
        WardController.wardService = wardService;
    }

    @RequestMapping(value = "/AddWard", method = RequestMethod.POST)
    public ModelAndView showForm() {
        return new ModelAndView("AddWard", "ward", new Ward());
    }

    /**
     * Display all the wards
     * 
     * @return    redirects to the page which shows all the wards.
     */
    @RequestMapping(value = "/DisplayAllWards", method = RequestMethod.GET)
    public ModelAndView displayAllWards() {
        ModelAndView mav = new ModelAndView(WardConstants.DISPLAYWARDS);
    	try {
            mav.addObject(WardConstants.WARDS , wardService.displayAllWards(WardConstants.ALL));
            mav.addObject(WardConstants.WARD , new Ward());
            mav.addObject(WardConstants.WARDIDS , getWards());
    	} catch(ApplicationException e) {
    		Logger.error(e);
            ModelAndView errorMav = new ModelAndView(WardConstants.NURSEHOME);
            errorMav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);
            return errorMav;
    	}
        return mav;
    }
    
    /**
     * Display all the wards
     * 
     * @return    redirects to the page which shows all the wards.
     */
    @RequestMapping(value = "/DisplayAllWards", method = RequestMethod.POST)
    public ModelAndView displayWards(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(WardConstants.DISPLAYWARDS);
    	try {
	    	String admitPatient = request.getParameter("admitButton");
	    	if(null != admitPatient) {
	    		mav.addObject(WardConstants.ADMITBUTTON, WardConstants.YES);
	    		mav.addObject("visitId",request.getParameter("visitId"));
	    	}
            mav.addObject(WardConstants.WARDS , wardService.displayAllWards(WardConstants.ALL));
            mav.addObject(WardConstants.WARD , new Ward());
            mav.addObject(WardConstants.WARDIDS , getWards());
    	} catch(ApplicationException e) {
    		Logger.error(e);
            ModelAndView errorMav = new ModelAndView(WardConstants.NURSEHOME);
            errorMav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);
            return errorMav;
    	}
        return mav;
    }
    

    /**
     * Display all the wards for the purpose for admitting the patient.
     * 
     *@param   visitId       visitId for which the bed is to be assigned.
     * 
     * @return ModelAndView  redirects to the page which displays all
     *                       the ward details.
     */
    @RequestMapping(value="/admitButton", method=RequestMethod.POST)
    public ModelAndView admitButton(@RequestParam(WardConstants.VISITID)String visitId) {
  	 ModelAndView mav = new ModelAndView(WardConstants.DISPLAYWARDS);
  	  try {
          mav.addObject(WardConstants.VISITID,visitId);
          mav.addObject(WardConstants.ADMITBUTTON, WardConstants.YES);
          mav.addObject(WardConstants.WARDS , wardService.displayAllWards(WardConstants.ALL));
          mav.addObject(WardConstants.WARD , new Ward());
          mav.addObject(WardConstants.WARDIDS , getWards());
        } catch(ApplicationException e) {
            ModelAndView errorMav = new ModelAndView(WardConstants.NURSEHOME);
    		Logger.error(e);
            errorMav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);
            return errorMav;
        }
  	    return mav;
    }
    

    @RequestMapping(value="/searchWardByNumber",
            produces={"application/json","application/xml"}, consumes="application/json",
    headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.GET)
    public @ResponseBody String searchWard(Model model,
            @RequestParam("wardNumber") String wardNumber) {
        try {
            Ward ward = wardService.searchWard(Integer.parseInt(wardNumber));
            return new Gson().toJson(ward.getRooms());
        } catch (ApplicationException e) {
            Logger.error(e);
            return null;
        }

    }
    /**
     * Allows to create a new ward with the specified number of rooms.
     * 
     * @param ward      Ward Information
     * 
     * @param noOfRooms Number to rooms to be created in a ward.
     * 
     * @return ModelAndView  redirects to the page which displays all
     *                       the ward details.
     */
    @RequestMapping(value="/AddWardInDB", method=RequestMethod.POST)
    public ModelAndView AddWardInDB(@RequestParam("wardName")String wardName) {
  		 ModelAndView mav = new ModelAndView("displayWards");
  	  try {
  		  Ward ward = new Ward();
  		  ward.setName(wardName);
          wardService.createWard(ward);
          mav.addObject("wards" , wardService.displayAllWards("All"));
          mav.addObject("ward" , new Ward());
        } catch(ApplicationException e) {
      	  
        }
  	  return mav;
    }

    /**
    * Make a ward status to maintaince.  
    *
    * @param ward  Ward Information
    *
    * @return ModelAndView  redirects to the page which displays all
    *                       the ward details.
    */
   @RequestMapping(value="/ChangeWardToMaintaince", method=RequestMethod.POST)
   public ModelAndView ChangeWardToMaintaince(@ModelAttribute(WardConstants.WARD) Ward ward) {
 
   ModelAndView mav = new ModelAndView("searchWard");
   try {
        wardService.deleteWard(wardService.searchWard(ward.getWardNumber()));
        ward = wardService.searchWard(ward.getWardNumber());
           mav.addObject(WardConstants.WARDNUMBER , ward.getWardNumber());
           mav.addObject(WardConstants.WARD , ward);
           mav.addObject("rooms", ward.getRooms());
       } catch(ApplicationException e) {
     Logger.error(e);
      mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);    
       }
   return mav;
   }
 
   
   /**
    * Make a ward status to free after maintaince.  
    *
    * @param ward  Ward Information
    *
    * @return ModelAndView  redirects to the page which displays all
    *                       the ward details.
    */    @RequestMapping(value="/ChangeWardToFree", method=RequestMethod.POST)
   public ModelAndView ChangeWardToFree(@RequestParam("number")String wardnumber) {
   ModelAndView mav = new ModelAndView("searchWard");
try {
Ward ward = new Ward();
       ward = wardService.searchWard(Integer.parseInt(wardnumber));
    wardService.changeWardToFree(ward);
    ward = wardService.searchWard(Integer.parseInt(wardnumber));
           mav.addObject(WardConstants.WARDNUMBER , Integer.parseInt(wardnumber));
           mav.addObject(WardConstants.WARD , ward);
           mav.addObject("rooms", ward.getRooms());
       } catch(ApplicationException e) {
   Logger.error(e);
    mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);    
       }
   return mav;

    }
  
    /**
     *  Displays all the inpatient details.
     *  
     * @return ModelAndView  redirects to the page which displays all
     *                       the Inpatient details.
     *                       
     */
	@RequestMapping(value="/nurseHome" , method= RequestMethod.GET)   
    public ModelAndView displayAllInPatients() {
		ModelAndView mav = new ModelAndView(WardConstants.NURSEHOME);
		try {
		    mav.addObject(WardConstants.INPATIENTS, wardService.getVisitsByPatientType("InPatient"));
		} catch(ApplicationException e) {
		    Logger.error(e);
	    	mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);  	  
		}
		return mav;
    }
    /**
     * Get all the ward details.
     * 
     * @return       List of ward details
     * 
     * @throws ApplicationException
     */
    public List<Integer> getWards() throws ApplicationException {
        List<Integer> wards = new ArrayList<Integer>();
        for(Ward wardIterator : wardService.displayAllWards(WardConstants.ALL)) {
         	wards.add(wardIterator.getWardNumber());
        }
        return wards;
    }
 
    /**
     * Allows to create rooms to the existing wards.
     * 
     * @param roomnumber Number of rooms to be added.
     * 
     * @return ModelAndView  redirects to the page which displays 
     *                       the ward details.
     */
    @RequestMapping(value="/openAddMenu", method=RequestMethod.POST)
    public ModelAndView openAddRooms(@RequestParam("number")String roomnumber) {
	    ModelAndView mav = new ModelAndView(WardConstants.DISPLAYWARDS);
	    try {
            mav.addObject(WardConstants.WARDS , wardService.displayAllWards(WardConstants.ALL));
            mav.addObject(WardConstants.ADDROOMSTOWARD , WardConstants.YES);
            mav.addObject(WardConstants.WARDNUMBER , Integer.parseInt(roomnumber));
            mav.addObject(WardConstants.WARD , new Ward());
            mav.addObject(WardConstants.WARDIDS , getWards());
        } catch(ApplicationException e) {
		    Logger.error(e);
	    	mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);  	  
        }
        return mav;
    }
  
    /**
     * Search a particular ward inforamtion with the help of ward number.
     * 
     * @param wardnumber ward number to be searched
     * 
     * @return ModelAndView  redirects to the page which displays all
     *                       the Inpatient details.
     */
    @RequestMapping(value="/searchWard", method=RequestMethod.POST)
    public ModelAndView searchWard(@RequestParam(WardConstants.WARDNUMBER)String wardnumber,HttpServletRequest request ) {
	    Ward ward = null;
	    ModelAndView mav = new ModelAndView("searchWard");
	    try {
	    	String admitPatient = request.getParameter("admitButton");
	    	if(null != admitPatient) {
	    		mav.addObject(WardConstants.ADMITBUTTON, WardConstants.YES);
	    		mav.addObject("visitId",request.getParameter("visitId"));
	    	}
		    ward = wardService.searchWard(Integer.parseInt(wardnumber));
            mav.addObject(WardConstants.WARDNUMBER , Integer.parseInt(wardnumber));
            mav.addObject(WardConstants.WARD , ward);
            mav.addObject("rooms", ward.getRooms());
        } catch(ApplicationException e) {
		    Logger.error(e);
	    	mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);  	  	  
        }
        return mav;
    }
    
    /**
     * Display all the rooms which are present in the ward.
     * 
     * @param ward ward information
     * 
     * @return     List of rooms present in the ward.
     * 
     * @throws ApplicationException
     */
    public List<Integer> getRooms(Ward ward) throws ApplicationException{
	     List<Integer> roomIds = new ArrayList<Integer>();
	     for(Room room : ward.getRooms()) {
		     roomIds.add(room.getRoomNumber());
	     }
	     return roomIds;
    }
  
    @RequestMapping(value="/AddRooms", method=RequestMethod.POST)
    public ModelAndView addRoomsToWard(@RequestParam(WardConstants.WARDNUMBER)String wardnumber,
   @RequestParam("noOfRooms")String noOfRooms) {
    ModelAndView mav = new ModelAndView("searchWard");
    try {
            Ward ward = wardService.searchWard(Integer.parseInt(wardnumber));
            wardService.addRoomsToWard(ward, Integer.parseInt(noOfRooms));
            ward = wardService.searchWard(Integer.parseInt(wardnumber));
            mav.addObject(WardConstants.WARDNUMBER , Integer.parseInt(wardnumber));
            mav.addObject(WardConstants.WARD , ward);
            mav.addObject("rooms", ward.getRooms());
        } catch(ApplicationException e) {
        Logger.error(e);
            mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);      
        }
    return mav;
 }
    
    /**
     * Search a particular ward information with the specified ward number
     * 
     * @param wardnumber ward number to be searched
     * 
     * @return ModelAndView  redirects to the page which displays 
     *                       the ward details.
     */
    @RequestMapping(value="/wardOperation", method=RequestMethod.POST, params="SearchWard")
    public ModelAndView SearchWard(@RequestParam("number")String wardnumber) {
	    Ward ward = new Ward();
	    ModelAndView mav = new ModelAndView(WardConstants.DISPLAYWARDS);
	    try {
            ward = wardService.searchWard(Integer.parseInt(wardnumber));
            mav.addObject(WardConstants.WARDS , wardService.displayAllWards(WardConstants.ALL));
            mav.addObject(WardConstants.WARD , new Ward());
            mav.addObject(WardConstants.WARDIDS , getWards());
        } catch(ApplicationException e) {
    	    Logger.error(e);
            mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);
        }
	    return mav;  
    }   
}
