package com.ideas2it.hospitalmanagement.ward.model;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.room.model.Room;



/**
 * <p>
 * Consist of all the details regarding the ward which contains ward number and 
 * status of the ward which represents whether they are allocated, free or under
 * maintaince.
 * </p>
 * @author Harish
 *
 */
public class Ward {
	
	private String name;
	private Integer wardNumber;
	private List<Room> rooms = new ArrayList<Room>();
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
    public List<Room> getRooms() {
		return rooms;
	}
    
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getWardNumber() {
		return wardNumber;
	}
	public void setWardNumber(Integer wardNumber) {
		this.wardNumber = wardNumber;
	}
	
	public String getBeds(Room room) {
		StringBuilder stringBuilder = new StringBuilder();
		for ( Bed bed : room.getBeds()) {
			stringBuilder.append(("\nbed" + bed.getBedNumber() + "\nstatus" + bed.getStatus() +
					"\nroomnumber" + bed.getRoomNumber()));
			
		}
		return stringBuilder.toString();
		
	}

	
	public String getRoomsInWard() {
		StringBuilder stringBuilder = new StringBuilder();
		for ( Room room : getRooms()) {
			stringBuilder.append(("\nroom" + room.getRoomNumber() + "\nwardNumber" +
		room.getWardNumber() + "\ngetBeds" + getBeds(room)));
			
		}
		return stringBuilder.toString();
	}
	public String toString() {
		return ("\nward numbe" + wardNumber + "\nward name" + name + "\nstatus" +
	    status + "\n rooms present" + getRoomsInWard());
		
	}
}
