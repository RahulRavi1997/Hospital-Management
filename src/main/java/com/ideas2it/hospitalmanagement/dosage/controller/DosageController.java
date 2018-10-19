package com.ideas2it.hospitalmanagement.dosage.controller;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.dosage.model.Dosage;
import com.ideas2it.hospitalmanagement.dosage.service.DosageService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * DosageController
 * <p>
 * Represents dosage prescribed by doctor to patients. All dosage details are
 * get from doctor and managed in this class.
 * <P>
 * 
 * @author Navaneeth and hariharan.
 */
@Controller
public class DosageController {

    private DosageService dosageService;

	public DosageService getDosageService() {
		return dosageService;
	}

	public void setDosageService(DosageService dosageService) {
		this.dosageService = dosageService;
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
	@RequestMapping(value = Constants.CREATE_DOSAGE_MAPPING, method = RequestMethod.POST)
	public ModelAndView addDosage(@ModelAttribute(Constants.DOSAGE) Dosage dosage) {
		try {
			dosageService.addDosage(dosage);
			return new ModelAndView(Constants.DOSAGE_JSP, Constants.DOSAGE_ADD_MESSAGE, Constants.PRESCRIPTION_SUCCESS);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR, Constants.DOSAGE_ADD_ERROR );
		}
	}

	/**
	 * <p>
	 * Used to show dosage details like number of tablet ,syrup..etc to client View
	 * for edit and update details.
	 * </p>
	 * 
	 * @param dosageId Unique Id of dosage.
	 * @return ModelAndView Used to represents the View which will be displayed to
	 *         the client.
	 */
	@RequestMapping(value = Constants.DISPLAY_DOSAGE_MAPPING, method = RequestMethod.POST)
	public ModelAndView displayDosage(@RequestParam(Constants.DOSAGE_ID) Integer dosageId) {
		try {
			return new ModelAndView(Constants.DOSAGE_JSP, Constants.DOSAGE, dosageService.serchDosageById(dosageId));
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR, Constants.DOSAGE_DISPLAY_ERROR );
		}
	}
}
