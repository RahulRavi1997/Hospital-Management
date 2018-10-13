package com.ideas2it.hospitalmanagement.prescriptionDetails.model;

import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.item.model.Item;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;

/**
 * <p>
 * PrescriptionDetails class is having the getters and setter methods which is
 * used to get the values and set values. This class acts as an Model for the
 * PrescriptionDetails.
 * <p>
 * 
 * @author navaneeth and hari
 */
public class PrescriptionDetails {
	private int id;
	private Prescription prescription;
	private Item item = new Item();
	private Dosage dosage = new Dosage();
	private int days;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Dosage getDosage() {
		return dosage;
	}

	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
}