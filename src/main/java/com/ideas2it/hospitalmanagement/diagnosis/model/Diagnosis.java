package com.ideas2it.hospitalmanagement.diagnosis.model;

import java.util.Date;

import javax.enterprise.inject.Model;
import org.springframework.format.annotation.DateTimeFormat;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * <p>
 * Diagonsis class is having the getters and setter methods which is used to get
 * the values and set values. This class acts as an Model for the Diagnosis
 * Details.
 * <p>
 * 
 * @author navaneeth and hari
 */
@Model
public class Diagnosis {
	private int id;
	private int visitId;
	private Date date;
	private String bloodGroup;
	private double height;
	private double weight;
	private double bloodSugar;
	private double bodyTemperature;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	@DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
	public Date getDate() {
		return date;
	}

	@DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
	public void setDate(Date date) {
		this.date = date;
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

	public double getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(double bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
}
