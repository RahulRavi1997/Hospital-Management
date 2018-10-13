package com.ideas2it.hospitalmanagement.prescription.controller;

import com.google.gson.Gson;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;
import com.ideas2it.hospitalmanagement.prescription.service.PrescriptionService;
import com.ideas2it.hospitalmanagement.prescriptionDetails.model.PrescriptionDetails;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * PrescriptionController
 * <p>
 * Represents a prescription prescribed by doctor to patient. All prescription
 * details like tablets , syrub are get from doctor and managed in this class.
 * <P>
 *
 * @author Navaneeth and Hari
 */
@Controller
public class PrescriptionController {
	private PrescriptionService prescriptionService;
	private VisitService visitService;

	public PrescriptionService getPrescriptionService() {
		return prescriptionService;
	}

	public void setPrescriptionService(PrescriptionService prescriptionService) {
		this.prescriptionService = prescriptionService;
	}

	public VisitService getVisitService() {
		return visitService;
	}

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	/**
	 * <p>
	 * Used to create a plain new Prescription Object and which is used to load
	 * Prescription form to client View.
	 * </p>
	 * 
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/createPrescription", method = RequestMethod.POST)
	public ModelAndView createPrescription(@RequestParam("visitId") Integer visitId,
			@RequestParam("visitType") String visitType) {
		ModelAndView modelAndView;
		try {
			if (visitType.equals("Out Patient")
					&& prescriptionService.fetchPrescriptionsByVisitId(visitId).size() != 0) {
				modelAndView = new ModelAndView("displayVisit");
				modelAndView.addObject("visits", visitService.getVisits());
				modelAndView.addObject("message", "Already Prescribed...");
				return modelAndView;
			} else {
				Prescription prescription = new Prescription();
				prescription.setVisitId(visitId);
				prescription.getPrescriptionDetails().add(new PrescriptionDetails());
				modelAndView = new ModelAndView("create_prescription");
				modelAndView.addObject("prescription", prescription);
				modelAndView.addObject("visitType", "Out Patient");
				return modelAndView;
			}
		} catch (ApplicationException e) {
			return new ModelAndView("error", "Error", e.getMessage());
		}

	}

	/**
	 * <p>
	 * Used to get all medicine name using ajax call which is used to load
	 * Prescription form to client View.
	 * </p>
	 * 
	 * @param name
	 *            Medicine Name.
	 * @return String it had all medicine which is available.
	 */
	@RequestMapping(value = "/getAllMedicines", produces = { "application/json",
			"application/xml" }, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.GET)
	private @ResponseBody String createPrescription(Model model, @RequestParam("search") String name) {
		try {
			return new Gson().toJson(prescriptionService.getAllItemsByName(name));
		} catch (ApplicationException e) {
			Logger.error(e);
			return null;
		}
	}

	/**
	 * <p>
	 * Used to create a plain new PrescriptionDetails Object and which is used to
	 * load PrescriptionDetails form to client View.
	 * </p>
	 * 
	 * @param prescription
	 *            It is a prescription object which have a prescription details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/createItem", method = RequestMethod.POST)
	public ModelAndView createItem(@ModelAttribute("prescription") Prescription prescription)
			throws ApplicationException {
		prescription.getPrescriptionDetails().add(new PrescriptionDetails());
		return new ModelAndView("create_prescription", "prescription", prescription);
	}

	/**
	 * <p>
	 * Used to get a Prescription details like number of tablet ,syrup..etc which is
	 * get from client View and send it to add operation and send response back to
	 * Client view whether it is added or not.
	 * </p>
	 * 
	 * @param prescription
	 *            It is a prescription object which have a prescription details.
	 * @param Model
	 *            Used to represents the View which will be displayed to the client
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/addPrescription", method = RequestMethod.POST)
	public ModelAndView addPrescription(@ModelAttribute("prescription") Prescription prescription, Model model,
			@RequestParam("visitType") String visitType) {
		ModelAndView modalAndView = new ModelAndView("displayVisit");
		try {
			prescriptionService.addPrescription(prescription);
			if (visitType.equals("In Patient")) {
				modalAndView = createPrescription(prescription.getVisitId(), visitType);
				model.addAttribute("addmsg", "Prescribed Successfully...");
				return modalAndView;
			} else {
				modalAndView.addObject("visits", visitService.getVisits());
				modalAndView.addObject("message", "Already Prescribed...");
				return modalAndView;
			}
		} catch (ApplicationException e) {
			return modalAndView.addObject("error", e.getMessage());
		}
	}

	/**
	 * <p>
	 * Used to get a Prescription details Id from client View and send it to remove
	 * operation and send response back to Client view whether it is removed or not.
	 * </p>
	 * 
	 * @param prescriptionId
	 *            It is a prescription Id which is unique.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/removePrescriptionDetail", method = RequestMethod.POST)
	public ModelAndView removePrescription(@ModelAttribute("prescription") Prescription prescription,
			@RequestParam("index") Integer index) {
		System.out.println(prescription.getPrescriptionDetails().remove((int) index));
		return new ModelAndView("create_prescription", "prescription", prescription);
	}

	/**
	 * <p>
	 * Used to get update id form to client View and send response back to view
	 * which used for editing prescription.
	 * </p>
	 * 
	 * @param prescription
	 *            It is a prescription object which have a prescription details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/editPrescription", method = RequestMethod.POST)
	public ModelAndView editPrescription(@ModelAttribute("prescription") Prescription prescription,
			@RequestParam("id") Integer prescriptionId) {
		try {
			prescription = prescriptionService.serchPrescriptionById(prescriptionId);
			return new ModelAndView("create_prescription", "prescription", prescription);
		} catch (ApplicationException e) {
			return new ModelAndView("error", "Error", "Error occured while display Prescription");
		}
	}

	/**
	 * <p>
	 * Used to show prescription details like number of tablet ,syrup..etc to client
	 * View for edit and update details.
	 * </p>
	 * 
	 * @param prescriptionId
	 *            Unique Id of prescription.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/ViewPrescriptions", method = RequestMethod.POST)
	public ModelAndView displayPrescriptionByVisitId(@RequestParam("visitId") Integer visitId) {
		ModelAndView modelView = null;
		try {
			return new ModelAndView("displayVisit", "prescriptions",
					prescriptionService.fetchPrescriptionsByVisitId(visitId));
		} catch (ApplicationException e) {
			return new ModelAndView("error", "Error", "Error occured while " + "displaying prescription");
		}
	}

	/**
	 * <p>
	 * Used to get a Prescription details like number of tablet ,syrup..etc which is
	 * get from client View and send it to update operation and send response back
	 * to Client view whether it is updated or not.
	 * </p>
	 * 
	 * @param prescription
	 *            It is a prescription object which have a updated prescription
	 *            details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/updatePrescription", method = RequestMethod.POST)
	public ModelAndView getUpdatedPrescription(@ModelAttribute("prescription") Prescription prescription) {
		try {
			prescriptionService.modifyPrescription(prescription);
			List<Prescription> prescriptions = new ArrayList<Prescription>();
			prescriptions.add(prescriptionService.serchPrescriptionById(prescription.getId()));
			return new ModelAndView("displayVisit", "prescriptions", prescriptions);
		} catch (ApplicationException e) {
			return new ModelAndView("error", "Error", "Error occured while Updating prescription");
		}
	}

}
