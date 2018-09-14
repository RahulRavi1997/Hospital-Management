package com.ideas2it.hospitalmanagement.room.service;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;;

public interface RoomService {
	
    /**
     *  <p>
     *  createRoom is a method which creates a room object and allocates
     *  5 beds in it.
     *  </p>
     *  
     *  @param room                             Room object
     *  
     *  @return room                            Room object
     */
	public Room createRoom(Room room) throws ApplicationException;
	
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
     *  updateRoom is a method which updates a given room in database.
     *  </p>
     *  
     *  @param room                             Room object
     *  
     *  @return boolean                         True if room is modified successfully
     *  										False if room modification fails
     */
	public boolean updateRoom(Room room) throws ApplicationException;
}