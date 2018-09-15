package com.ideas2it.hospitalmanagement.room.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.dao.RoomDao;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.room.service.impl.RoomServiceImpl;
import com.ideas2it.hospitalmanagement.ward.model.Ward;

@Controller
public class RoomController{

	private static RoomService roomService;
	
	public static RoomService getRoomService() {
		return roomService;
	}

	public static void setRoomService(RoomServiceImpl roomService) {
		RoomController.roomService = roomService;
	}
	  @RequestMapping(value="/searchRoom", method=RequestMethod.POST)
	  public ModelAndView searchRoom(@RequestParam("roomNumber")String roomNumber,
			  		@RequestParam("wardNumber")String wardNumber) {
		 Room room;
		 ModelAndView mav = new ModelAndView("searchRoom");
		  try { 
			room = roomService.searchRoomByNumber(Integer.parseInt(roomNumber));
	        mav.addObject("wardNumber" ,wardNumber);
	        mav.addObject("room",room);
	  } catch(ApplicationException e) {
		  
	  }
	  return mav;
	}
	  
	  public List<Integer> getWardIds() throws ApplicationException {
	      List<Integer> wardIds = new ArrayList<Integer>();
	      for(Ward wardIterator : roomService.getWards()) {
	      	wardIds.add(wardIterator.getWardNumber());
	      }
	      return wardIds;
	  }
	  
	  public List<Integer> getRoomIds(Ward ward) throws ApplicationException {
	      List<Integer> roomIds = new ArrayList<Integer>();
	      for(Room roomIterator : ward.getRooms()) {
	    	  roomIds.add(roomIterator.getRoomNumber());
	      }
	      return roomIds;
	  }
}