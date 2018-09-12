package com.ideas2it.hospitalmanagement.prescription.model;

import java.util.List;

import com.ideas2it.hospitalmanagement.prescriptionDetails.model.PrescriptionDetails;

public class Prescription {
    private int id;
    private int visitId; 
    private List <PrescriptionDetails> prescriptions;
    
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
	
    public List <PrescriptionDetails> getPrescriptions() {
		return prescriptions;
	}
	
	public void setPrescription(List <PrescriptionDetails> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
}
