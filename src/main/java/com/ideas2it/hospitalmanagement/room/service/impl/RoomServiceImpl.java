package com.ideas2it.hospitalmanagement.room.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.dao.RoomDao;
import com.ideas2it.hospitalmanagement.room.dao.impl.RoomDaoImpl;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.service.WardService;
import com.ideas2it.hospitalmanagement.ward.service.impl.WardServiceImpl;

public class RoomServiceImpl implements RoomService {

	private static RoomDao roomDao;
	private static WardService wardService;
	
    public static WardService getWardService() {
		return wardService;
	}

	public static void setWardService(WardServiceImpl wardService) {
		RoomServiceImpl.wardService = wardService;
	}

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
	
    /**
     *  {@inheritDoc}
     */
	public boolean updateRoom(Room room) throws ApplicationException {
		return roomDao.updateRoom(room);
	}
	
	public List<Ward> getWards() throws ApplicationException {
		return wardService.displayAllWards("All");
	}

	public Ward getWardByNumber(int wardNumber) throws ApplicationException {
		return wardService.searchWard(wardNumber);
	}
}