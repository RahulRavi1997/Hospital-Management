package com.ideas2it.hospitalmanagement.room.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.ward.model.Ward;;


/**
 * RoomService is the Service interface which is having the several data manipulation methods and
 * this class does the business logic operations on the room related Details.
 * <p>
 * It has the Implementation class which is performing the business logic operations on the bed
 * Details.
 * </p>
 *
 * @author latheesh
 * @version 1.0
 */
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
	
	/**
	 * Gets all the wards.
	 * 
	 * @return List of wards.
	 * 
	 * @throws ApplicationException
	 */
	public List<Ward> getWards() throws ApplicationException;

	/**
	 * Search a particular ward with the help of the ward number.
	 * 
	 * @param wardNumber ward number to be searched.
	 * 
	 * @return ward      Ward Information
	 * 
	 * @throws ApplicationException
	 */
	public Ward getWardByNumber(int wardNumber)throws ApplicationException;
	
	
	/**
	 * Search a particular bed with the help of the bed number.
	 * 
	 * @param bedNumber Bed number to be searched.
	 * 
	 * @return Bed      Bed Information
	 * 
	 * @throws ApplicationException
	 */
	public Bed getBedByNumber(int bedNumber) throws ApplicationException;
}
