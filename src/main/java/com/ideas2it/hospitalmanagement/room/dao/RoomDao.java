package com.ideas2it.hospitalmanagement.room.dao;


import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;
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
     *  insertRoom is a method which inserts a room object inside the
     *  database.
     *  </p>
     *  
     *  @param room                             Room object
     *  
     *  @return boolean
     */
     public boolean insertRoom(Room room) throws ApplicationException;
  
}


