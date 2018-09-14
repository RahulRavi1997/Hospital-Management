package com.ideas2it.hospitalmanagement.visit.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * Visit class is the Entity class is having the getters and setter methods
 * which monitors Patient Visit to the Hospital.This class acts as an Model
 * for the Visit Details of an Patient.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class Visit {

    public Visit() {
    }

    private Integer id;
    private Date admitDate;
    private Date dischargeDate;
    private Integer patientId;
    private Integer physicianId;
	private String patientType;

    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getAdmitDate() {
		return admitDate;
	}
    @DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
    @DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getPhysicianId() {
		return physicianId;
	}
	public void setPhysicianId(Integer physicianId) {
		this.physicianId = physicianId;
	}
    public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
}