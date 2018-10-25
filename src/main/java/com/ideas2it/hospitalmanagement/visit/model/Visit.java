package com.ideas2it.hospitalmanagement.visit.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
import com.ideas2it.hospitalmanagement.physician.model.Physician;

/**
 * Visit class is the model class which monitors Patient Visit to the Hospital.
 * An Visit Object is Created Each time when Patient Visits the Hospital.
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
    private Patient patient;
    private Physician physician;
	private String patientType;
	private String patientStatus = "Yet To Admit";
	
    public String getPatientStatus() {
		return patientStatus;
	}
	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

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
    public void setAdmitDate(final Date admitDate) {
        this.admitDate = admitDate;
    }

    @DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
    public Date getDischargeDate() {
        return dischargeDate;
    }

    @DateTimeFormat(pattern = Constants.REVERSED_DATE_FORMAT)
    public void setDischargeDate(final Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(final Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(final Physician physician) {
        this.physician = physician;
    }

    public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
}
