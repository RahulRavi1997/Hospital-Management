package com.ideas2it.hospitalmanagement.room.controller;

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

@Controller
public class RoomController{

	private static RoomService roomService;
	
	public static RoomService getRoomService() {
		return roomService;
	}

	public static void setRoomService(RoomService roomService) {
		RoomController.roomService = roomService;
	}

}