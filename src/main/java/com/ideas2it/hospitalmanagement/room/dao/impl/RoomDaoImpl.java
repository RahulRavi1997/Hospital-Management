package com.ideas2it.hospitalmanagement.room.dao.impl;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.room.common.Constants;
import com.ideas2it.hospitalmanagement.room.dao.RoomDao;
import com.ideas2it.hospitalmanagement.room.model.Room;

/**
 * RoomDaoImpl is the dao class implements the RoomDao interface and
 * it is processing all the interface methods and this class is having its own
 * method to fetch the room details of the ward.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove,
 * Search and Display the details in the Database implements the RoomDao
 * interface functions.
 * </p>
 * ArrayList is used to store the values of the bed details which are
 * gathered from the Database.
 *
 * @author    latheesh
 * @version   1.0
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
            throw new ApplicationException(errorMessage.toString());
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
            errorMessage.append(ERROR_UPDATING_ROOM).append(room.getRoomNumber());
            throw new ApplicationException(errorMessage.toString());
        }
    }
 }
