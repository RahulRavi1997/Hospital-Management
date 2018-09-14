package com.ideas2it.hospitalmanagement.room.service.impl;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.dao.RoomDao;
import com.ideas2it.hospitalmanagement.room.dao.impl.RoomDaoImpl;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;
import com.ideas2it.hospitalmanagement.ward.service.WardService;

public class RoomServiceImpl implements RoomService {

	private static RoomDao roomDao;
	private static WardService wardService;
    
    public static RoomDao getRoomDao() {
		return roomDao;
	}

	public static void setRoomDao(RoomDaoImpl roomDao) {
		RoomServiceImpl.roomDao = roomDao;
	}

    /**
     *  {@inheritDoc}
     */
	public Room createRoom(Room room) throws ApplicationException {
		System.out.println("entered room service");
		Bed bed;
		for(int i = 0; i < 5; i++) {
			bed = new Bed();
			room.getBeds().add(bed);
		}
	    return room;
	}
	
    /**
     *  {@inheritDoc}
     */
	public Room searchRoomByNumber(int roomNumber) throws ApplicationException {
		return roomDao.searchRoomByNumber(roomNumber);
	}
	
	public boolean updateRoom(Room room) throws ApplicationException {
		return roomDao.updateRoom(room);
	}
}