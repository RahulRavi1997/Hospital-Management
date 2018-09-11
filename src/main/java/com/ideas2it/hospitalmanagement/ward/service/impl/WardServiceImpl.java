package com.ideas2it.hospitalmanagement.ward.service.impl;


import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.room.service.RoomService;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.ward.dao.WardDao;
import com.ideas2it.hospitalmanagement.ward.service.WardService;

public class WardServiceImpl implements WardService {
	
    private static WardDao wardDao;
    private static RoomService roomService;

  
    public  void setWardDao(WardDao wardDao) {
       this.wardDao = wardDao;

    }

    public  void setRoomService(RoomService roomService) {
        this.roomService = roomService;

     }
    /**
     * Create a new ward along with the specified rooms based on the
     * room type.
     * @param    ward    Ward information
     */
	public boolean createWard(Ward ward) throws ApplicationException {
		if (Constants.ICU.equals(ward.getName())) {
			for (int count = 0; count < 2 ; count++) {
				ward.getRooms().add(roomService.createRoom(new Room(), "ICU"));	
			}
		}
		
		if (Constants.PICU.equals(ward.getName())) {
			for (int count = 0; count < 3 ; count++) {
				ward.getRooms().add(roomService.createRoom(new Room() , "PICU"));	
			}
			
		}

		if (Constants.EMERGENCYWARD.equals(ward.getName())) {
			for (int count = 0; count < 3 ; count++) {
				ward.getRooms().add(roomService.createRoom(new Room() , Constants.EMERGENCYWARD));	
			}
			
		}

		if (Constants.GENERAL.equals(ward.getName())) {
			for (int count = 0; count < 5 ; count++) {
				ward.getRooms().add(roomService.createRoom(new Room(), Constants.GENERAL ));	
			}
			
		}

		return wardDao.insertWard(ward);		
		
	}
	
	public boolean updateWard(Ward ward) throws ApplicationException {
        return wardDao.updateWard(ward);		
	
	}


	public Ward searchWard(Integer wardNumber) throws ApplicationException {
		return wardDao.searchWard(new Ward(), "WardNumber", wardNumber );
		
	}
	
}