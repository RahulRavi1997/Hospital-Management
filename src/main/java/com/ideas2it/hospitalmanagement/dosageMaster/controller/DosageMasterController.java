package com.ideas2it.hospitalmanagement.dosageMaster.controller;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
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
	@RequestMapping(value = Constants.CREATE_DOSAGE, method = RequestMethod.GET)
	public ModelAndView createDosage() {
		ModelAndView modalAndView = new ModelAndView(Constants.WELCOME_URL);
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
	 * @param dosage It is a dosage object which have a dosage details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.DOSAGE_URL, method = RequestMethod.POST)
	public ModelAndView getDosage(@ModelAttribute(Constants.DOSAGE) DosageMaster dosage) {
		try {
			dosageMasterService.addDosage(dosage);
			return new ModelAndView(Constants.DOSAGE_PAGE, Constants.DOSAGE_ADD_MESSAGE, Constants.PRESCRIPTION_SUCCESS);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR, Constants.DOSAGE_ADD_ERROR);
		}
	}

	/**
	 * <p>
	 * Used to get dosage details from client View and send it to update operation
	 * and send response back to Client view whether it is updated or not.
	 * </p>
	 * 
	 * @param dosage It is a dosage object which have a updated dosage details.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.UPDATE_DOSAGE_URL, method = RequestMethod.POST)
	public ModelAndView getUpdatedDosage(@ModelAttribute(Constants.DOSAGE) DosageMaster dosage) {
		try {
			dosageMasterService.modifyDosage(dosage);
			return new ModelAndView(Constants.DOSAGE_PAGE, Constants.ADD_DOSAGE_MSG, Constants.UPDATE_MSG);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,  Constants.DOSAGE_UPDATE_ERROR);
		}
	}

	/**
	 * <p>
	 * Used to show all dosage details to client View.
	 * </p>
	 * 
	 * @param dosage It is a dosage name.
	 * @return String Used to represents the dosages in the form of json string.
	 */
	@RequestMapping(value = Constants.DISPLAY_URL, produces = { Constants.JSON,
			Constants.APP }, consumes = Constants.JSON, headers = Constants.JSON_CONFIG, method = RequestMethod.GET)
	private @ResponseBody String getAllDosage(Model model, @RequestParam(Constants.DOSAGE) String name) {
		return new Gson().toJson(dosageMasterService.getAllDosage(name));
	}
}
