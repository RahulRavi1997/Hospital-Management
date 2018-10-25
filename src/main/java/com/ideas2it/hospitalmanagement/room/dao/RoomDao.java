package com.ideas2it.hospitalmanagement.room.dao;


import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.ward.model.Ward;

/**
 * RoomDao is the DAO interface program which is having the methods that is processing the data
 * access operations of the room related Details.
 * <p>
 * It is having the implementation classes, which performs the Add,Modify, Remove,Search and Display
 * the room details.
 * </p>
 * This interface has a method to gather details of all the room and its related details that are stored in the
 * Database.
 *
 * @author latheesh
 * @version 1.0
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


