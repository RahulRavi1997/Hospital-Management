package com.ideas2it.hospitalmanagement.room.dao.impl;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.room.common.Constants;
import com.ideas2it.hospitalmanagement.room.dao.RoomDao;
import com.ideas2it.hospitalmanagement.room.model.Room;
;
/**
 * <p>
 * RoomDAOImpl class takes of creation of rooms.
 * </p>
 * @author Latheesh
 *
 */
public class RoomDaoImpl extends GenericDao implements RoomDao{

    private static final String ERROR_SEARCHING_ROOM = 
			"Exception occured while searching Room : ";

    private static final String ERROR_UPDATING_ROOM = 
			"Exception occured while updating Room : ";
    
    /**
     *  {@inheritDoc}
     */
 	public Room searchRoomByNumber(int roomNumber) throws ApplicationException{
        try {
        	return super.getByAttribute(Room.class,Constants.ROOMNUMBER,roomNumber);
        } catch (ApplicationException e) {
            Logger.error(Constants.ROOM_NOT_ADDED, e); 
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append(ERROR_SEARCHING_ROOM).append(roomNumber);
            throw new ApplicationException(errorMessage);
        }
    }
 	
    /**
     *  {@inheritDoc}
     */ 	
    public boolean updateRoom(Room room) throws ApplicationException {
        try {
            return super.update(room);
        } catch (ApplicationException e) {
            Logger.error(Constants.ROOM_NOT_UPDATED, e );
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append(ERROR_UPDATING_ROOM).append(room.getBedNumber());
            throw new ApplicationException(errorMessage);
        }
    }
 }
