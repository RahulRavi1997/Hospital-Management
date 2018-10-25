package com.ideas2it.hospitalmanagement.bedallocation.model;

import java.util.Date;

import com.ideas2it.hospitalmanagement.bed.model.Bed;
import com.ideas2it.hospitalmanagement.visit.model.Visit;



/**
 * Helps to create a new bed alloction details when a patient is admitted to
 * the bed.It consist of all the bed allocation details which can be used 
 * for the futher purpose of searched a patient with the specified bed
 * number.
 * @author  harish
 * @version 1.0
 */
public class BedAllocation {
	private int bedAllocationId;
	private Bed bed;
	private Date admitDate;
	private Date dischargeDate;
	private Visit visit;
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Bed getBed() {
		return bed;
	}
	public void setBed(Bed bed) {
		this.bed = bed;
	}
	
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
	public Date getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}
	
	public int getBedAllocationId() {
		return bedAllocationId;
	}
	public void setBedAllocationId(int bedAllocationId) {
		this.bedAllocationId = bedAllocationId;
	}
}
