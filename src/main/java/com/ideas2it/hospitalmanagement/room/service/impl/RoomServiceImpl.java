package com.ideas2it.hospitalmanagement.room.service.impl;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.bed.service.BedService;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;

public class RoomServiceImpl implements RoomService {
	
    private static WardDao wardDao;
    private static BedService bedService;

  
    public  void setWardDao(WardDao wardDao) {
       this.wardDao = wardDao;

    }

    public  void setBedService(BedService bedService) {
        this.bedService = bedService;

     }
 
	
	public Room createRoom(Room room, String roomType) throws ApplicationException {
		
		if (roomType.equals(Constants.ICU)) {
		    for (int count = 0; count < 1; count++ ) {
		    	room.getBeds().add(bedService.createBed(new Bed()));
		    }
			
		}
		
		if (roomType.equals(Constants.PICU)) {
		    for (int count = 0; count < 3; count++ ) {
		    	room.getBeds().add(bedService.createBed(new Bed()));
		    }

			
		}
		if (roomType.equals(Constants.EMERGENCYWARD)) {
		    for (int count = 0; count < 3; count++ ) {
		    	room.getBeds().add(bedService.createBed(new Bed()));
		    }

			
		}
		if (roomType.equals(Constants.GENERAL)) {
		    for (int count = 0; count < 5; count++ ) {
		    	room.getBeds().add(bedService.createBed(new Bed()));
		    }

			
		}

	    return room;
	}
}