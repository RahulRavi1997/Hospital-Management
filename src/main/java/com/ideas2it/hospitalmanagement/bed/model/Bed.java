package com.ideas2it.hospitalmanagement.bed.model;
/**
 * <p>
 * Consist of all the details regarding the bed which contains bed number and 
 * status of the bed which represents whether they are allocated, free or under
 * maintaince.
 * </p>
 * @author Harish
 *
 */
public class Bed {

	private Integer bedNumber;
	private String status = "Available";
	private Integer visitId;
	private Integer roomNumber;
	
	public Integer getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getVisitId() {
		return visitId;
	}
	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

		
	
}
