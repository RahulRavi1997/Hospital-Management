package com.ideas2it.hospitalmanagement.prescriptionDetails.model;

import java.util.List;

public class PrescriptionDetails {
	int prescriptionId;
	int itemId;
    int dosageId;
    int quenatity;
    
	public int getPrescriptionId() {
		return prescriptionId;
	}
	
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getDosageId() {
		return dosageId;
	}
	
	public void setDosageId(int dosageId) {
		this.dosageId = dosageId;
	}
	
	public int getQuenatity() {
		return quenatity;
	}
	
	public void setQuenatity(int quenatity) {
		this.quenatity = quenatity;
	}
}