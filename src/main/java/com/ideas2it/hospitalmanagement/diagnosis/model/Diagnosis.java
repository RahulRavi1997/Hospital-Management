package com.ideas2it.hospitalmanagement.diagnosis.model;

import java.util.Date;

import javax.enterprise.inject.Model;

@Model
public class Diagnosis {

	private Integer id;
	private Integer doctorId;
	private Date date;
	private String bloodGroup;
	private double height;
	private double weight;
	private double bloodSugar;
	private double cholestrol;
	private double bloodPressure;
	private boolean bodyTemperature;
	public Integer getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBloodSugar() {
		return bloodSugar;
	}

	public void setBloodSugar(double bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public double getCholestrol() {
		return cholestrol;
	}

	public void setCholestrol(double cholestrol) {
		this.cholestrol = cholestrol;
	}

	public double getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public boolean isBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(boolean bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
	
}
