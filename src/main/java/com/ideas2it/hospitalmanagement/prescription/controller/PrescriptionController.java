package com.ideas2it.hospitalmanagement.prescription.controller;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription; 
import com.ideas2it.hospitalmanagement.prescription.service.PrescriptionService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * PrescriptionController
 * <p>
 *  Represents a prescription prescribed by doctor to patient.
 *  All prescription details like tablets , syrub  are get from 
 *  doctor and managed in this class.  
 * <P>
 *
 * @author Navaneeth 
 */
@Controller
public class PrescriptionController {
	
    private PrescriptionService prescriptionService; 
	
	public PrescriptionService getPrescriptionService() {
		return prescriptionService;
	}

	public void setPrescriptionService(PrescriptionService prescriptionService) {
		this.prescriptionService = prescriptionService;
	}

	/**
     * <p>
     *   Used to create a plain new  Prescription Object and which is used to load 
     *   Prescription form  to client View.
     * </p>
     *    
     * @return   ModelAndView        Used to represents the View which will be 
     *                               displayed to the client.
     */
    @RequestMapping(value = "/createPrescription" , method = RequestMethod.GET) 
	public ModelAndView createPrescription() {
    	ModelAndView  modalAndView = new ModelAndView("welcome");
        Prescription prescription = new Prescription(); 
        return modalAndView;
	}
    
    /**
     * <p>
     *   Used to get a Prescription details like number of tablet ,syrup..etc  which is get 
     *   from client View and send it to add operation and send response back to
     *    Client view whether it is added or not.    
     * </p>
     *  
     * @param    prescription        It is a prescription object which have a 
     *                               prescription details. 
     *
     * @return   ModelAndView        Used to represents the View which will be 
     *                               displayed to the client.
     */
    @RequestMapping(value = "/addPrescription", method = RequestMethod.POST)
    public ModelAndView getPrescription(@ModelAttribute("prescription")Prescription prescription) {
        try {
        	prescriptionService.addPrescription(prescription);
            return new  ModelAndView("Prescription.jsp", "prescription-add-msg" ,"Prescribed Successfully...");      
        } catch (ApplicationException e) {
        	return new  ModelAndView(); 
        } 
    }  
    
    /**
     * <p>
     *   Used to get a Patient Id from client View for getting prescription history of particular 
     *   patient and send it response back to Client view.    
     * </p>
     *  
     * @param    patientId           Unique Id of patient. 
     *
     * @return   ModelAndView        Used to represents the View which will be 
     *                               displayed to the client.
     */
    @RequestMapping(value = "displayPrescriptions", method = RequestMethod.POST)
    public ModelAndView displayPrescriptionsHistroy(@RequestParam("patientId")Integer patientId ) {
    	ModelAndView modalAndView = new ModelAndView("Prescription.jsp"); 
        try {
        	modalAndView.addObject("prescriptions", prescriptionService.fetchPrescriptionsByPatientId(patientId));
        	return modalAndView; 
        } catch (ApplicationException e) {
        	return new  ModelAndView(); 
        } 
    }  
    
    /**
     * <p>
     *  Used to show prescription details like number of tablet ,syrup..etc to 
     *  client View for edit and update details.    
     * </p>
     *  
     * @param    prescriptionId      Unique Id of prescription.  
     *
     * @return   ModelAndView        Used to represents the View which will be 
     *                               displayed to the client.
     */
    @RequestMapping(value = "displayPrescription", method = RequestMethod.POST)
    public ModelAndView displayPrescription(@RequestParam("prescriptionId")Integer prescriptionId) {
        try {
        	return new  ModelAndView("Prescription.jsp", "prescription", prescriptionService.serchPrescriptionById(prescriptionId));      
        } catch (ApplicationException e) {
        	return new  ModelAndView(); 
        } 
    }   
    
    /**
     * <p>
     *   Used to get a Prescription details like number of tablet ,syrup..etc  which is get 
     *   from client View and send it to update operation and send response back to
     *    Client view whether it is updated or not.    
     * </p>
     *  
     * @param    prescription        It is a prescription object which have a 
     *                               updated prescription details. 
     *
     * @return   ModelAndView        Used to represents the View which will be 
     *                               displayed to the client.
     */
    @RequestMapping(value = "updatePrescription", method = RequestMethod.POST)
    public ModelAndView getUpdatedPrescription(@ModelAttribute("prescription")Prescription prescription) {
        try {
        	prescriptionService.modifyPrescription(prescription);
            return new  ModelAndView("Prescription.jsp", "prescription-update-msg", "Prescription Updated...");      
        } catch (ApplicationException e) {
        	return new  ModelAndView(); 
        } 
    }  
}
