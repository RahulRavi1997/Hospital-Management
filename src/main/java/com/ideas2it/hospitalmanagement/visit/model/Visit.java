package com.ideas2it.hospitalmanagement.visit.model;

import java.util.Date;

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
    private Integer doctorId;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}   
}