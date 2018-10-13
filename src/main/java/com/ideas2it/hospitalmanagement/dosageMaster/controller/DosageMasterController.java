package com.ideas2it.hospitalmanagement.dosageMaster.controller;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.dosageMaster.model.DosageMaster;
import com.ideas2it.hospitalmanagement.dosageMaster.service.DosageMasterService;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * DosageMasterController
 * <p>
 * Represents dosageMaster which contains a list of all dosages which can be
 * made available during prescription.
 * <P>
 * 
 * @author Navaneeth and hariHaran..
 */
@Controller
public class DosageMasterController {

	private DosageMasterService dosageMasterService;

	public DosageMasterService getDosageMasterService() {
		return dosageMasterService;
	}

	public void setDosageMasterService(DosageMasterService dosageMasterService) {
		this.dosageMasterService = dosageMasterService;
	}

	/**
	 * <p>
	 * Used to create a plain new dosage Object and which is used to load dosage
	 * form to client View.
	 * </p>
	 * 
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/createDosage", method = RequestMethod.GET)
	public ModelAndView createDosage() {
		ModelAndView modalAndView = new ModelAndView("welcome");
		DosageMaster dosage = new DosageMaster();
		return modalAndView;
	}

	/**
	 * <p>
	 * Used to get a Dosage details like number of tablet ,syrup..etc which is get
	 * from client View and send it to add operation and send response back to
	 * Client view whether it is added or not.
	 * </p>
	 * 
	 * @param dosage
	 *            It is a dosage object which have a dosage details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "/getDosage", method = RequestMethod.POST)
	public ModelAndView getDosage(@ModelAttribute("dosage") DosageMaster dosage) {
		try {
			dosageMasterService.addDosage(dosage);
			return new ModelAndView("Dosage.jsp", "dosage-add-msg", "Prescribed Successfully...");
		} catch (ApplicationException e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * <p>
	 * Used to get dosage details from client View and send it to update operation
	 * and send response back to Client view whether it is updated or not.
	 * </p>
	 * 
	 * @param dosage
	 *            It is a dosage object which have a updated dosage details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = "updateDosage", method = RequestMethod.POST)
	public ModelAndView getUpdatedDosage(@ModelAttribute("dosage") DosageMaster dosage) {
		try {
			dosageMasterService.modifyDosage(dosage);
			return new ModelAndView("Dosage.jsp", "dosage-update-msg", "Dosage Updated...");
		} catch (ApplicationException e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * <p>
	 * Used to show all dosage details to client View.
	 * </p>
	 * 
	 * @param dosage
	 *            It is a dosage name.
	 * @return String Used to represents the dosages in the form of json string.
	 */
	@RequestMapping(value = "/getAllDosage", produces = { "application/json",
			"application/xml" }, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.GET)
	private @ResponseBody String getAllDosage(Model model, @RequestParam("dosage") String name) {
		try {
			return new Gson().toJson(dosageMasterService.getAllDosage(name));
		} catch (ApplicationException e) {
			return null;
		}
	}
}
