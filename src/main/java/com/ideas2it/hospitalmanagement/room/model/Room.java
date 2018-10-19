package com.ideas2it.hospitalmanagement.room.model;

import java.util.List;
import java.util.ArrayList;

import com.ideas2it.hospitalmanagement.bed.model.Bed;

public class Room {
	
	private Integer roomNumber;
	private List<Bed> beds = new ArrayList<Bed>();
	private Integer wardNumber;

	
    public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getWardNumber() {
		return WardNumber;
	}

	public void setWardNumber(Integer wardNumber) {
		WardNumber = wardNumber;
	}

	private Integer WardNumber;
	
    public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}
}