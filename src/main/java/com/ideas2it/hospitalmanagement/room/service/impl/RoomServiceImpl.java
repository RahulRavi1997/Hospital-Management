package com.ideas2it.hospitalmanagement.room.service.impl;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.common.Constants;
import com.ideas2it.hospitalmanagement.room.dao.RoomDao;
import com.ideas2it.hospitalmanagement.room.dao.impl.RoomDaoImpl;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.service.WardService;
import com.ideas2it.hospitalmanagement.ward.service.impl.WardServiceImpl;

public class RoomServiceImpl implements RoomService {

	private static RoomDao roomDao;
	private static WardService wardService;
	private static BedService bedService;
	private static VisitService visitService;

	public static void setVisitService(VisitService visitService) {
		RoomServiceImpl.visitService = visitService;
	}


	public static void setBedService(BedService bedService) {
		RoomServiceImpl.bedService = bedService;
	}
	
	public static void setWardService(WardServiceImpl wardService) {
		RoomServiceImpl.wardService = wardService;
	}

	public static void setRoomDao(RoomDaoImpl roomDao) {
		RoomServiceImpl.roomDao = roomDao;
	}
    /**
     *  {@inheritDoc}
     */
	public Room createRoom(Room room) throws ApplicationException {
		Bed bed;
		bed = new Bed();
		room.getBeds().add(bed);
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
	
    /**
     *  {@inheritDoc}
     */
	public List<Ward> getWards() throws ApplicationException {
		return wardService.displayAllWards(Constants.ALL);
	}

    /**
     *  {@inheritDoc}
     */
	public Ward getWardByNumber(int wardNumber) throws ApplicationException {
		return wardService.searchWard(wardNumber);
	}
	
    /**
     *  {@inheritDoc}
     */
	public Bed getBedByNumber(int bedNumber) throws ApplicationException {
		return bedService.searchBedByNumber(bedNumber);
	}
}