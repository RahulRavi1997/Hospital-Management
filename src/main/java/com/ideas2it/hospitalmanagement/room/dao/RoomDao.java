package com.ideas2it.hospitalmanagement.room.dao;


import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.ward.model.Ward;
/**
 * <p>
 * RoomDAO is an interface which holds methods for creation and updation of rooms.
 * </p>
 * @author Latheesh
 *
 */
public interface RoomDao {
      
     /**
      *  <p>
      *  searchRoomByNumber is a method which searches for a room for the
      *  given Room Number
      *  </p>
      *  
      *  @param roomNumber                        Room Number
      *  
      *  @return room                             Room object
      */
 	public Room searchRoomByNumber(int roomNumber) throws ApplicationException;
 	
    /**
     *  <p>
     *  updateRoom is a method which updates a room object inside the
     *  database.
     *  </p>
     *  
     *  @param room                               Room object
     *  
     *  @return boolean
     */
    public boolean updateRoom(Room room) throws ApplicationException;
}


