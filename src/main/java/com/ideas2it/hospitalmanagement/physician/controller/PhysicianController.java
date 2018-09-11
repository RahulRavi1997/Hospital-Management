package com.ideas2it.hospitalmanagement.physician.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ideas2it.hospitalmanagement.address.model.Address;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.physician.model.Physician;
import com.ideas2it.hospitalmanagement.physician.service.PhysicianService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
/**
 * <p>
 * PhysicianController is a Controller Class, which is used to implement
 * data storage and retrieval operations on Physician Data. The physicians
 * can be assigned to many patients at the same time. It uses HttpServlets and
 * Spring MVC to be hosted as a web Application. Service Layer beans are
 * injected during runtime using Spring Dependency injection.
 * </p>
 * @author    Rahul Ravi
 * @version   1.0
 *
 */
@Controller
public class PhysicianController {

    public PhysicianService physicianService = null;

    public void setPhysicianService(PhysicianService physicianService) {
        this.physicianService = physicianService;
    }

    public PhysicianService getPhysicianService() {
        return this.physicianService;
    }

    /**
     *  This Method is used to redirect user to the webpage with the form used
     *  to create and add a new Physician.
     *
     *  @param model a Model object which is used to add the physician as an
     *               attribute to the view Layer.
     *
     *  @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.CREATE_PHYSICIAN_MAPPING, method=RequestMethod.GET)
    private ModelAndView redirectToCreatePhysician(Model model) {

    	Physician physician = new Physician();
        physician.setAddress(new Address());
        return new ModelAndView(Constants.CREATE_PHYSICIAN_JSP, Constants.PHYSICIAN, physician);
    }


    /**
     *  This Method is used to add a new Physician after obtaining all the
     *  physician details from the user. Redirects to error page if any error
     *  occurs, else redirects to display page for the physician.
     *
     * @param physician an Physician object with all the details of the physician
     *                 to be added.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.ADD_PHYSICIAN_MAPPING, method=RequestMethod.POST)
    private ModelAndView createPhysician(@ModelAttribute Physician physician, Model model) {
        try {
            if (!physicianService.addPhysician(physician)) {
                return new ModelAndView(Constants.ERROR_JSP, Constants.
                    ERROR_MESSAGE, Constants.PHYSICIAN_ADDITION_EXCEPTION);
            }
            model.addAttribute(Constants.MESSAGE, Constants.
            		PHYSICIAN_ADD_SUCCESS_MESSAGE);
            return new ModelAndView(Constants.SEARCH_PHYSICIAN_JSP, Constants.
                    PHYSICIAN, physician);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
            		String.format(Constants.PHYSICIAN_ADDITION_EXCEPTION,
            				physician.getFirstName(), physician.getLastName()));
        }

    }

    /**
     * This Method is used to restore a deleted physician. Redirects to display
     * all physicians on successful restoration.
     *
     * @param id an Integer indicating the id of the physician to be restored or
     *           reactivated.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.RESTORE_PHYSICIAN_MAPPING, method=RequestMethod.POST)
    private ModelAndView restorePhysician(@RequestParam(Constants.ID) int id, Model model) {
        try {
            if (physicianService.restorePhysician(id)) {
                model.addAttribute(Constants.MESSAGE, Constants.PHYSICIAN_RESTORE_SUCCESS_MESSAGE);
                return new ModelAndView(Constants.SEARCH_PHYSICIAN_JSP, Constants.
                        PHYSICIAN, physicianService.retrievePhysicianById(id));
            } else {
                return new ModelAndView(Constants.ERROR_JSP, Constants.
                        ERROR_MESSAGE, Constants.PHYSICIAN_EDIT_EXCEPTION);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.PHYSICIAN_RESTORE_EXCEPTION, id));
        }
    }

    /**
     *  <p>
     *  Method to update existing Physician Details. Returns true if the entry
     *  is modified successfully, else returns false if the entry is not found.
     *  </p>
     *
     * @param id an Integer indicating the id of the physician to be modified.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.MODIFY_PHYSICIAN_MAPPING, method=RequestMethod.GET)
    private ModelAndView modifyPhysician(@RequestParam(Constants.ID) int id) {
        try {
            return new ModelAndView(Constants.CREATE_PHYSICIAN_JSP,Constants.
                    PHYSICIAN, physicianService.retrievePhysicianById(id));
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.PHYSICIAN_EDIT_EXCEPTION, id));
        }
    }

    /**
     *  <p>
     *  Method to update existing Physician Details. Returns true if the entry
     *  is modified successfully, else returns false if the entry is not found.
     *  </p>
     *
     * @param physician an Physician object with the updated details of the
     *                 physician.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.UPDATE_PHYSICIAN_MAPPING, method=RequestMethod.POST)
    private ModelAndView updatePhysician(@ModelAttribute Physician physician, Model model) {

        try {
            if (!physicianService.modifyPhysician(physician)) {
                return new ModelAndView(Constants.ERROR_JSP, Constants.
                        ERROR_MESSAGE, Constants.EDIT_FAILED);
            }
            model.addAttribute(Constants.MESSAGE, Constants.PHYSICIAN_UPDATE_SUCCESS_MESSAGE);
            return new ModelAndView(Constants.SEARCH_PHYSICIAN_JSP,Constants.
                    PHYSICIAN, physician);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.PHYSICIAN_EDIT_EXCEPTION, physician.getId()));
        }

    }

    /**
     * This Method is used to remove an existing physician by Id given by the
     * user.
     *
     * @param idToDelete an Integer indicating the id of the physician to be
     *                   deleted.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.DELETE_PHYSICIAN_MAPPING, method=RequestMethod.POST)
    private ModelAndView removePhysician(@RequestParam(Constants.ID) int idToDelete, Model model) {
        try {
            if (!physicianService.deletePhysician(idToDelete)) {
                return new ModelAndView(Constants.ERROR_JSP, Constants.
                        ERROR_MESSAGE, Constants.PHYSICIAN_DELETE_EXCEPTION);
            }
            model.addAttribute(Constants.MESSAGE, Constants.PHYSICIAN_DELETE_SUCCESS_MESSAGE);
            return new ModelAndView(Constants.SEARCH_PHYSICIAN_JSP, Constants.
                    PHYSICIAN, physicianService.retrievePhysicianById(idToDelete));
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.PHYSICIAN_DELETE_EXCEPTION, idToDelete));
        }
    }

    /**
     * This Method is used to search for an physician by the id given by the
     * user. Displays the physician's details if there is a match.
     *
     * @param id an Integer indicating the id of the physician to be retrieved.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.SEARCH_PHYSICIAN_MAPPING, method=RequestMethod.GET)
    private ModelAndView searchPhysician(@RequestParam(Constants.ID) int id) {
        try {
            Physician physician = physicianService.retrievePhysicianById(id);
            if (null == physician) {
                return new ModelAndView(Constants.SEARCH_PHYSICIAN_JSP, Constants.
                    FAIL_MESSAGE, String.format(Constants.SEARCH_FAIL_MESSAGE, id));
            }
            return new ModelAndView(Constants.SEARCH_PHYSICIAN_JSP, Constants.
                    PHYSICIAN, physician);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.PHYSICIAN_SEARCH_EXCEPTION, id));
        }
    }

    /**
     * This Method is used to display all details of the physicians.
     *
     * @return response a HttpServletResponse object which is used to redirect
     *                 or send text output.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.DISPLAY_PHYSICIAN_MAPPING, method=RequestMethod.GET)
    private ModelAndView displayAllPhysicians(Model model) {
        try {
            List<Physician> physicians = physicianService.retrieveAllPhysicians();
            model.addAttribute(Constants.PHYSICIANS, physicians);
            return new ModelAndView(Constants.DISPLAY_PHYSICIAN_JSP,
            		Constants.NUMBER_OF_PHYSICIANS, physicians.size());
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    Constants.PHYSICIAN_DISPLAY_EXCEPTION);
        }
    }
}