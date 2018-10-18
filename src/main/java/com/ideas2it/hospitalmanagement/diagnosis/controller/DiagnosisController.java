package com.ideas2it.hospitalmanagement.diagnosis.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.diagnosis.model.Diagnosis;
import com.ideas2it.hospitalmanagement.diagnosis.service.DiagnosisService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * <p>
 * Diagnosis Controller is a Controller Class, which is used perform create,
 * read,update and delete operations for diagnosis
 * </p>
 * 
 * @author Hariharasudan and Navaneeth
 * @version 1.0
 */
@Controller
public class DiagnosisController {

	private DiagnosisService diagnosisService = null;

	public void setDiagnosisService(DiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}

	public DiagnosisService getDiagnosisService() {
		return this.diagnosisService;
	}

	/**
	 * This Method is used to redirect user to the webpage with the form used to
	 * create and add a new Diagnosis.
	 *
	 * @param model a Model object which is used to add the diagnosis information as
	 *              an attribute to the view Layer.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = "/create_diagnosis", method = RequestMethod.POST)
	private ModelAndView redirectToCreateDiagnosis() {

		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setVisitId(1);
		diagnosis.setDate(new Date());
		return new ModelAndView(Constants.CREATE_DIAGNOSIS_JSP, Constants.DIAGNOSIS, diagnosis);
	}

	/**
	 * This Method is used to add a new diagnosis after obtaining all the details
	 * from the doctor. Redirects to error page if any error occurs.
	 *
	 * @param diagnosis an Diagnnosis object with all the diagnosis information to
	 *                  be added.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = Constants.ADD_DIAGNOSIS_MAPPING, method = RequestMethod.POST)
	private ModelAndView createDiagnosis(@ModelAttribute Diagnosis diagnosis, Model model) {
		ModelAndView modelAndView = redirectToCreateDiagnosis();
		try {
			diagnosisService.createDiagnosis(diagnosis);
			model.addAttribute(Constants.MESSAGE, Constants.DIAGONSIS_ADD_SUCCESS_MESSAGE);
			return modelAndView;
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					String.format(Constants.DIAGNOSIS_ADDITION_EXCEPTION, diagnosis.getId()));
		}

	}

	/**
	 * This Method is used to view all the list of diagnosis
	 *
	 * @return modelAndView a ModelAndView object which is used to add the list as
	 *         attributes
	 */
	@RequestMapping(value = "/viewAllDiagnosis", method = RequestMethod.POST)
	public ModelAndView viewAllDiagnosis() {
		try {
			List<Diagnosis> diagnosis = diagnosisService.retrieveDiagnosisByVisit(1);
			System.out.println(diagnosis);
			return new ModelAndView("DisplayAllDiagnosis", "diagnosis", diagnosis);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.ITEM_DISPLAY_EXCEPTION);
		}
	}

	/**
	 * <p>
	 * Method to update existing diagnosis Details. Returns true if the entry is
	 * modified successfully, else returns false if the entry is not found.
	 * </p>
	 *
	 * @param id an Integer indicating the id of the diagnosis information to be
	 *           modified.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = "/edit_diagnosis", method = RequestMethod.POST)
	private ModelAndView redirectToEditDiagnosis(@RequestParam(Constants.ID) int id) {
		try {
			return new ModelAndView(Constants.CREATE_DIAGNOSIS_JSP, Constants.DIAGNOSIS,
					diagnosisService.retrieveDiagnosisById(id));
		} catch (ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					String.format(Constants.DIAGNOSIS_EDIT_EXCEPTION, id));
		}

	}

	/**
	 * <p>
	 * Method to save the updated diagnosis Details to Database. Returns true if the
	 * entry is modified successfully, else returns false if the entry is not found.
	 * </p>
	 *
	 * @param a modified Diagnosis object to be saved.
	 * @return modelAndView a ModelAndView object which is used to list all
	 *         diagnosis in a list
	 */
	@RequestMapping(value = Constants.UPDATE_DIAGNOSIS_MAPPING, method = RequestMethod.POST)
	private ModelAndView updateDiagnosis(@ModelAttribute Diagnosis diagnosis, Model model) {
		ModelAndView modelAndView;
		try {
			diagnosisService.modifyDiagnosis(diagnosis);
			model.addAttribute(Constants.MESSAGE, Constants.DIAGNOSIS_UPDATE_SUCCESS_MESSAGE);
			modelAndView = viewAllDiagnosis();
			return modelAndView;
		} catch (ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					String.format(Constants.DIAGNOSIS_EDIT_EXCEPTION, diagnosis.getId()));
		}

	}
}
