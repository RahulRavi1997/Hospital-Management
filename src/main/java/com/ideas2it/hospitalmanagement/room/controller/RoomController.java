package com.ideas2it.hospitalmanagement.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.room.service.impl.RoomServiceImpl;

@Controller
public class RoomController{
	
	private static RoomService roomService;
	
    public static RoomService getRoomService() {
		return roomService;
	}
	public static void setRoomService(RoomServiceImpl roomService) {
		RoomController.roomService = roomService;
	}
	
	/**
     * <p>
     * addEmployee method is to add the employee to the database.
     * </p>
     *
     * @param employee               Employee object
     *
     * @return ModelAndView           Used for displaying the view for the 
     *                               application user.
     */ 
    @RequestMapping(value="/admitPatient" , method= RequestMethod.POST)   
    public ModelAndView admitPatient(@RequestParam("roomNumber") int roomNumber,@RequestParam("bedNumber") 
    										int bedNumber,	@RequestParam("visitId") int visitId) {
    	
        ModelAndView modelAndView = new ModelAndView("");
        try {
        	Room room;
			room = roomService.searchRoomByNumber(roomNumber);
			int roomIndex = roomNumber % 5;
			if(roomIndex <= 5 && roomIndex > 0) {
				roomIndex = roomIndex - 1;
			} else if(roomIndex >= 5) {
				roomIndex = roomIndex - 6;
			} else {
				roomIndex = 4;
			}
			if(room.getBeds().get(roomIndex).getStatus().equals("Available")) {
				room.getBeds().get(roomIndex).setVisitId(visitId);
			} else {
				//Bed is not available
			}
			if(null != room) {
				room.getBeds().get(roomIndex).setVisitId(visitId);
				if(roomService.updateRoom(room)) {
					//Attach successful message on admission
				} else {
					//Attach fail message on admission
				}
			} 
			return modelAndView;
        } catch (ApplicationException e) {
        	//Attach an exception message for model.
        	return modelAndView;
		} 
    }
    
    @RequestMapping(value="/dischargePatient" , method= RequestMethod.POST)   
    public ModelAndView dischargePatient(@RequestParam("roomNumber") int roomNumber,@RequestParam("bedNumber") 
    										int bedNumber,	@RequestParam("visitId") int visitId) {
    	
        ModelAndView modelAndView = new ModelAndView("");
        try {
        	Room room;
			room = roomService.searchRoomByNumber(roomNumber);
			int roomIndex = bedNumber % 10;
			
			if(roomIndex <= 5 && roomIndex > 0) {
				roomIndex = roomIndex - 1;
			} else if(roomIndex >= 5) {
				roomIndex = roomIndex - 6;
			} else {
				roomIndex = 4;
			}
			
			if(null != room) {
				room.getBeds().get(roomIndex).setVisitId(null);
				room.getBeds().get(roomIndex).setStatus("Available");
				if(roomService.updateRoom(room)) {
					//Attach successful message on admission
				} else {
					//Attach fail message on discharging
				}
			} else {
				//Attach a wrong message for model.
			}
			return modelAndView;
        } catch (ApplicationException e) {
        	//Attach an exception message for model.
        	return modelAndView;
		} 
    }	
}