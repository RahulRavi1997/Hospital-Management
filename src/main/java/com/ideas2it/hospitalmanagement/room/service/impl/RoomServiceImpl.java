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

/**
 * RoomServiceImpl is the Service class implementing the RoomService interface and this
 * implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to do the data accessing
 * operations.
 * </p>
 *
 * @author latheesh
 * @version 1.0
 */
public class RoomServiceImpl implements RoomService {

	private RoomDao roomDao;
	private WardService wardService;
	private BedService bedService;
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}


	public void setBedService(BedService bedService) {
		this.bedService = bedService;
	}
	
	public void setWardService(WardService wardService) {
		this.wardService = wardService;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
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