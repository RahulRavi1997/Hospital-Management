package com.ideas2it.hospitalmanagement.ward.model;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.hospitalmanagement.room.model.Room;

public class Ward {
	
	private String name;
	private Integer wardNumber;
	private List<Room> rooms = new ArrayList<Room>();
	
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
	public Integer getWardId() {
		return wardNumber;
	}
	public void setWardId(Integer wardNumber) {
		this.wardNumber = wardNumber;
	}
	
}