package com.ideas2it.hospitalmanagement.prescriptionDetails.model;

public class PrescriptionDetails {
	int id;
    int prescriptionId;
	int itemId;
    int dosageId;
    int quantity;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}