package com.ideas2it.hospitalmanagement.dosage.model;

/**
 * <p>
 * Dosage class is having the getters and setter methods which is used to get
 * the values and set values. This class acts as an Model for the Prescription
 * Details.
 * <p>
 * 
 * @author navaneeth and hari
 */
public class Dosage {
	private int dosageId;
	private String dosage;
	private int quantity;

	public int getDosageId() {
		return dosageId;
	}

	public void setDosageId(int dosageId) {
		this.dosageId = dosageId;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}