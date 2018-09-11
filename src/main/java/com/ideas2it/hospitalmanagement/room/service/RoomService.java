package com.ideas2it.hospitalmanagement.room.service;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;;

public interface RoomService {
	
	public Room createRoom(Room room, String roomType) throws ApplicationException;
	
}