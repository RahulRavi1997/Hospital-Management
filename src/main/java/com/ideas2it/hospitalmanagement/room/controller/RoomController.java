package com.ideas2it.hospitalmanagement.room.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.bed.commons.constants.BedConstants;
import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.room.common.Constants;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.room.service.impl.RoomServiceImpl;
import com.ideas2it.hospitalmanagement.ward.commons.constants.WardConstants;

@Controller
public class RoomController{

	private static RoomService roomService;
	
	public static void setRoomService(RoomServiceImpl roomService) {
		RoomController.roomService = roomService;
	}
	
	/**
	 * Search a room with the specified room number and its corresponding
	 * ward number.
	 * @param roomNumber room number to be searched.
	 * 
	 * @param wardNumber ward numbr of the corresponding room.
	 * 
	 * @return  redirects to the page which displays the specified room.
	 */
	@RequestMapping(value="/searchRoom", method=RequestMethod.POST)
	public ModelAndView searchRoom(@RequestParam(Constants.ROOMNUMBER)String roomNumber,
			  		@RequestParam(WardConstants.WARDNUMBER)String wardNumber,HttpServletRequest request) {
	    Room room;
		ModelAndView mav = new ModelAndView(Constants.SEARCHROOM);
		try { 
	    	String admitPatient = request.getParameter(Constants.ADMITBUTTON);
	    	if(null != admitPatient) {
	    		mav.addObject(Constants.ADMITBUTTON, Constants.YES);
	    		mav.addObject(Constants.VISITID,request.getParameter(Constants.VISITID));
	    	}
			room = roomService.searchRoomByNumber(Integer.parseInt(roomNumber));
	        mav.addObject(WardConstants.WARDNUMBER ,wardNumber);
	        mav.addObject(Constants.ROOM,room);
	    } catch(ApplicationException e) {
			mav.addObject(BedConstants.FAIL_MESSAGE,e);  
  	    	mav.addObject(WardConstants.FAILURE_MESSAGE, WardConstants.FAILURE_MESSAGE);  	  
  	    }
	    return mav;
	}
	
    /**
     * <p>
     * Display the patient details who corresponds to the particular bed.
     * </p>
     * 
     * @param visitId							Visit Id
     * 
     * @return ModelAndView 					Used for displaying the view for the 
     *                               			application user.
     */	@RequestMapping(value="/displayPatientDetails", method=RequestMethod.POST)
	public ModelAndView displayPatientDetails(@RequestParam(BedConstants.BEDNUMBER)String bedNumber,
	
			@RequestParam(Constants.ROOMNUMBER)String roomNumber) {
 		ModelAndView mav = new ModelAndView(Constants.SEARCHROOM);

	    try {
			Bed bed = roomService.getBedByNumber(Integer.parseInt(bedNumber));
			Room room = roomService.searchRoomByNumber(Integer.parseInt(roomNumber));
            mav.addObject(WardConstants.WARDNUMBER ,room.getWardNumber());
            mav.addObject(Constants.PATIENTDETAILS , Constants.YES);
            mav.addObject(Constants.BEDDETAILS , bed);
            mav.addObject(Constants.VISITDETAILS , bed.getVisit());

	        mav.addObject(Constants.ROOM,room);
	        } catch(ApplicationException e) {
			mav.addObject(BedConstants.FAIL_MESSAGE,e);  
	    }
	  	return mav; 
	}
    
   
     /**
      * <p>
      * Display the patient details who corresponds to the particular bed.
      * </p>
      * 
      * @param visitId							Visit Id
      * 
      * @return ModelAndView 					Used for displaying the view for the 
      *                               			application user.
      */	@RequestMapping(value="/AddBeds", method=RequestMethod.POST)
 	public ModelAndView AddBeds(@RequestParam(Constants.WARDNUMBER) String wardNumber,
 									@RequestParam(Constants.ROOMNUMBER)String roomNumber) {
  		ModelAndView mav = new ModelAndView(Constants.SEARCHROOM);

 	    try {
 			 Room room = roomService.searchRoomByNumber(Integer.parseInt(roomNumber));
             room.getBeds().add(new Bed());
             roomService.updateRoom(room);
             room = roomService.searchRoomByNumber(Integer.parseInt(roomNumber));
             mav.addObject(Constants.ROOM, room);
             mav.addObject(Constants.WARDNUMBER, wardNumber);
 	        } catch(ApplicationException e) {
 			mav.addObject(BedConstants.FAIL_MESSAGE,e);  
 	    }
 	  	return mav; 
 	}
}
