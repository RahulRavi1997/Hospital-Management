package com.ideas2it.hospitalmanagement.prescription.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ideas2it.hospitalmanagement.prescriptionDetails.model.PrescriptionDetails;

/**
 * <p>
 * Prescription class is having the getters and setter methods which is used to
 * get the values and set values. This class acts as an Model for the
 * Prescription Details.
 * <p>
 * 
 * @author navaneeth and hari
 */
public class Prescription {
	private int id;
	private int visitId;
	private Date prescriptionDate;
	private List<PrescriptionDetails> prescriptionDetails = new ArrayList<PrescriptionDetails>();

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

	public List<PrescriptionDetails> getPrescriptionDetails() {
		return prescriptionDetails;
	}

	public void setPrescriptionDetails(List<PrescriptionDetails> prescriptionDetails) {
		this.prescriptionDetails = prescriptionDetails;
	}

	public Date getPrescriptionDate() {
		return new Date();
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
}
