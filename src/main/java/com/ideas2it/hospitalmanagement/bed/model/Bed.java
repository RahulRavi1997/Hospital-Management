package com.ideas2it.hospitalmanagement.bed.model;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.hospitalmanagement.bed.commons.constants.BedConstants;
import com.ideas2it.hospitalmanagement.bedallocation.model.BedAllocation;
import com.ideas2it.hospitalmanagement.visit.model.Visit;

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
	private String status = BedConstants.AVAILABLE;
	private Visit visit;
	private Integer roomNumber;
	private List<BedAllocation> bedAllocations = new ArrayList<BedAllocation>();

	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
	public List<BedAllocation> getBedAllocations() {
		return bedAllocations;
	}
	public void setBedAllocations(List<BedAllocation> bedAllocations) {
		this.bedAllocations = bedAllocations;
	}
	
	
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

	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}	
}
