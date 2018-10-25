package com.ideas2it.hospitalmanagement.prescription.controller;

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

import com.google.gson.Gson;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.prescription.model.Prescription;
import com.ideas2it.hospitalmanagement.prescription.service.PrescriptionService;
import com.ideas2it.hospitalmanagement.prescriptionDetails.model.PrescriptionDetails;

/**
 * PrescriptionController
 * <p>
 * Represents a prescription prescribed by doctor to patient. All prescription
 * details like tablets , syrub are get from doctor and managed in this class.
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
	 * Used to create a plain new Prescription Object and which is used to load
	 * Prescription form to client View.
	 * </p>
	 * 
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.CREATE_PRESCRIPTION_MAPPING, method = RequestMethod.POST)
	public ModelAndView createPrescription(@RequestParam(Constants.VISIT_ID) Integer visitId,
			@RequestParam(Constants.VISIT_TYPE) String visitType) {
		ModelAndView modelAndView;
		try {
			if (visitType.equals(Constants.OUT_PATIENT) && prescriptionService.fetchPrescriptionsByVisitId(visitId).size() != 0) {
				modelAndView = new ModelAndView(Constants.DISPLAY_VISIT);
				// modelAndView.addObject(Constants.VISITS, visitService.getVisits());
				modelAndView.addObject(Constants.MESSAGE, Constants.CREATE_ERROR);
				return modelAndView;
			} else {
				Prescription prescription = new Prescription();
				prescription.setVisitId(visitId);
				prescription.getPrescriptionDetails().add(new PrescriptionDetails());
				modelAndView = new ModelAndView(Constants.CREATE_PRESCRIPTION);
				modelAndView.addObject(Constants.PRESCRIPTION, prescription);
				modelAndView.addObject(Constants.VISIT_TYPE, Constants.OUT_PATIENT);
				return modelAndView;
			}
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR, e.getMessage());
		}

	}

	/**
	 * <p>
	 * Used to create a plain new PrescriptionItemDetails Object and which is used
	 * to load PrescriptionDetails form to client View.
	 * </p>
	 * 
	 * @param prescription It is a prescription object which have a prescription
	 *                     details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.CREATE_PRESCRIPTION_ITEM_MAPPING, method = RequestMethod.POST)
	public ModelAndView createItem(@ModelAttribute("prescription") Prescription prescription)
			throws ApplicationException {
		prescription.getPrescriptionDetails().add(new PrescriptionDetails());
		return new ModelAndView(Constants.CREATE_PRESCRIPTION, Constants.PRESCRIPTION, prescription);
	}

	/**
	 * <p>
	 * Used to get a Prescription details like number of tablet ,syrup..etc which is
	 * get from client View and send it to add operation and send response back to
	 * Client view whether it is added or not.
	 * </p>
	 * 
	 * @param prescription It is a prescription object which have a prescription
	 *                     details.
	 * @param Model        Used to represents the View which will be displayed to
	 *                     the client
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.ADD_PRESCRIPTION_MAPPING, method = RequestMethod.POST)
	public ModelAndView addPrescription(@ModelAttribute(Constants.PRESCRIPTION) Prescription prescription, Model model,
			@RequestParam(Constants.VISIT_TYPE) String visitType) {
		ModelAndView modalAndView = new ModelAndView(Constants.DISPLAY_VISIT);
		try {
			prescriptionService.addPrescription(prescription);
			if (visitType.equals(Constants.IN_PATIENT)) {
				modalAndView = createPrescription(prescription.getVisitId(), visitType);
				model.addAttribute(Constants.ADD_MESSAGE, Constants.PRESCRIPTION_SUCCESS);
				return modalAndView;
			} else {
				// modalAndView.addObject(Constants.VISITS, visitService.getVisits());
				modalAndView.addObject(Constants.MESSAGE, Constants.CREATE_ERROR);
				return modalAndView;
			}
		} catch (ApplicationException e) {
			return modalAndView.addObject(Constants.ERROR, e.getMessage());
		}
	}

	/**
	 * <p>
	 * Used to get a Prescription details Id from client View and send it to remove
	 * operation and send response back to Client view whether it is removed or not.
	 * </p>
	 * 
	 * @param prescriptionId It is a prescription Id which is unique.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.REMOVE_PRESCRIPTION_MAPPING, method = RequestMethod.POST)
	public ModelAndView removePrescription(@ModelAttribute(Constants.PRESCRIPTION) Prescription prescription,
			@RequestParam(Constants.INDEX) Integer index) {
		System.out.println(prescription.getPrescriptionDetails().remove((int) index));
		return new ModelAndView(Constants.CREATE_PRESCRIPTION,Constants.PRESCRIPTION, prescription);
	}

	/**
	 * <p>
	 * Used to get update id form to client View and send response back to view
	 * which used for editing prescription.
	 * </p>
	 * 
	 * @param prescription It is a prescription object which have a prescription
	 *                     details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.EDIT_PRESCRIPTION_MAPPING, method = RequestMethod.POST)
	public ModelAndView editPrescription(@ModelAttribute(Constants.PRESCRIPTION) Prescription prescription,
			@RequestParam(Constants.ID) Integer prescriptionId) {
		try {
			prescription = prescriptionService.serchPrescriptionById(prescriptionId);
			return new ModelAndView(Constants.CREATE_PRESCRIPTION, Constants.PRESCRIPTION, prescription);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR, Constants.PRESCRIPTION_DISPLAY_ERROR);
		}
	}

	/**
	 * <p>
	 * Used to show prescription details like number of tablet ,syrup..etc to client
	 * View for edit and update details.
	 * </p>
	 * 
	 * @param prescriptionId Unique Id of prescription.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.VIEW_PRESCRIPTION_MAPPING, method = RequestMethod.POST)
	public ModelAndView displayPrescriptionByVisitId(@RequestParam(Constants.VISIT_ID) Integer visitId) {
		ModelAndView modelView = null;
		try {
			return new ModelAndView(Constants.VIEW_VISIT,Constants.PRESCRIPTIONS,
					prescriptionService.fetchPrescriptionsByVisitId(visitId));
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR, Constants.PRESCRIPTION_DISPLAY_ERROR);
		}
	}

	/**
	 * <p>
	 * Used to get a Prescription details like number of tablet ,syrup..etc which is
	 * get from client View and send it to update operation and send response back
	 * to Client view whether it is updated or not.
	 * </p>
	 * 
	 * @param prescription It is a prescription object which have a updated
	 *                     prescription details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.UPDATE_PRESCRIPTION_MAPPING, method = RequestMethod.POST)
	public ModelAndView getUpdatedPrescription(@ModelAttribute("prescription") Prescription prescription) {
		try {
			prescriptionService.modifyPrescription(prescription);
			List<Prescription> prescriptions = new ArrayList<Prescription>();
			prescriptions.add(prescriptionService.serchPrescriptionById(prescription.getId()));
			return new ModelAndView(Constants.VIEW_VISIT, Constants.PRESCRIPTIONS, prescriptions);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR, Constants.PRESCRIPTION_UPDATE_ERROR);
		}
	}
	
	/**
	 * <p>
	 * Used to get all medicine name using ajax call which is used to load
	 * Prescription form to client View.
	 * </p>
	 * 
	 * @param name Medicine Name.
	 * @return String it had all medicine which is available.
	 */
	@RequestMapping(value = Constants.GET_MEDICINES_MAPPING, produces = { Constants.JSON,
			Constants.APP }, consumes = Constants.JSON, headers = Constants.JSON_CONFIG, method = RequestMethod.GET)
	private @ResponseBody String createPrescription(Model model, @RequestParam("search") String name) {
		try {
			return new Gson().toJson(prescriptionService.getAllItemsByName(name));
		} catch (ApplicationException e) {
			return null;
		}
	}
}
