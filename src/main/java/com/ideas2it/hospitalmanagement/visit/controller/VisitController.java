package com.ideas2it.hospitalmanagement.visit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.commons.enums.PatientType;
import com.ideas2it.hospitalmanagement.commons.enums.Specialisation;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
import com.ideas2it.hospitalmanagement.visit.model.Visit;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;

/**
 * VisitController is the controller class for the Visit, which allows the Receptionist User to
 * create a visit when a patient arrives to the Hospital also able to view the visit Details.
 * <p>
 * The Operations that can be done using this application are Adding a visit Details, Modifying the
 * visit Details, Removing the visit Details, Searching for a visit details and Displaying the visit
 * Details.
 * </p>
 * The visit Controller class is mapped with Controller Annotation of Spring Framework by which the
 * Class is mapped to the Spring MVC.
 *
 * @author Arul Murugan
 * @version 1.0
 */
@Controller
public class VisitController {

    private VisitService visitService;

    public void setVisitService(final VisitService visitService) {
        this.visitService = visitService;
    }

    /**
     * <p>
     * This method is called when the request value is createVisit and this is the Get method, which is
     * used to redirect to the Create Visit page. This method returns the value as ModelAndView Class
     * Object contains the Model having the Visit object with List as Address Object.
     * </p>
     *
     * @param model a Model object which is used to add the Visit as an attribute to the view Layer.
     * @return ModelAndView Object which redirects to the Create visit Page.
     */
    @RequestMapping(value = Constants.CREATE_VISIT, method = RequestMethod.GET)
    public ModelAndView getVisitDetailsFromUser(final Model model) {

        final Visit visit = new Visit();
        model.addAttribute(Constants.TYPES, PatientType.values());
        model.addAttribute(Constants.SPECIALISATIONS, Specialisation.values());
        return new ModelAndView(Constants.CREATE_VISIT_JSP, Constants.VISIT_OBJECT, visit);
    }

    /**
     * <p>
     * This method is called when the request value is addVisit and this is the Post method which
     * contains the visitObject Details is added to the Database. It redirects to the SearchVisit page
     * to display the visit when object is successfully added or redirects to the Error page if any
     * failure in adding the visit Object to Database.This method returns the value as ModelAndView
     * Class Object.
     * </p>
     *
     * @param visit visit Object which is added to the Database.
     * @param patientId Integer with patientId value from which the Patient Object is obtained.
     * @param physicianId Integer with physicianId value from which the physician Object is obtained.
     * @return ModelAndView Object which redirects to the Search visit Page or Error Page.
     */
    @RequestMapping(value = Constants.ADD_VISIT, method = { RequestMethod.POST, RequestMethod.GET })
    private ModelAndView createVisit(@ModelAttribute(Constants.VISIT) final Visit visit,
            @RequestParam(Constants.PATIENT_ID) final Integer patientId,
            @RequestParam(Constants.PHYSICIAN_ID) final Integer physicianId) {

        try {
            visit.setAdmitDate(new Date());
            visitService.addVisit(visit, patientId, physicianId);
            return new ModelAndView(Constants.SEARCH_VISIT_JSP, Constants.VISIT_OBJECT, visit);
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_ADD_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is modifyVisit and this is the Get method which gets
     * the visit Object Details which is needed to modify. It gets the visit Object from the Id given by
     * the User and the respective visit Object is redirects to the Create visit page. This method
     * returns the value as ModelAndView Class Object.
     * </p>
     *
     * @param visitId Integer with visitId value from which the visit Object is obtained from the
     *                Database.
     * @param model a Model object which is used to add the Visit as an attribute to the view Layer.
     * @return ModelAndView Object which redirects to the Create visit Page with the visitObject or to
     *         the Error Page.
     */
    @RequestMapping(value = Constants.MODIFY_VISIT, method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView getVisitToModify(@RequestParam(Constants.ID) final Integer visitId, final Model model) {

        try {
            final Visit visit = visitService.getVisitById(visitId);
            model.addAttribute(Constants.TYPES, PatientType.values());
            model.addAttribute(Constants.SPECIALISATIONS, Specialisation.values());
            return new ModelAndView(Constants.UPDATE_VISIT_JSP, Constants.VISIT_OBJECT, visit);
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_SEARCH_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is updateVisit and this is the Post method which
     * contains the visit Object Details that needs to be updated in the Database. It redirects to the
     * Search visit page to display the Updated visit Object when successfully Updated or redirects to
     * the Error Page when any failure in Modifying the visit Object to Database.This method returns the
     * value as ModelAndView Object.
     * </p>
     *
     * @param visit visit Object which is added to the Database.
     * @return ModelAndView Object which redirects to the Search visit Page or to the Error Page.
     */
    @RequestMapping(value = Constants.UPDATE_VISIT, method = { RequestMethod.POST, RequestMethod.GET })
    private ModelAndView updateVisit(@ModelAttribute(Constants.VISIT) final Visit visit,
            @RequestParam(Constants.PATIENT_ID) final Integer patientId,
            @RequestParam(Constants.PHYSICIAN_ID) final Integer physicianId) {
        try {
            visitService.modifyVisit(visit, patientId, physicianId);
            return new ModelAndView(Constants.SEARCH_VISIT_JSP, Constants.VISIT_OBJECT, visit);
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_UPDATE_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is search Visit and this is the Get method which
     * gets the visit Object Details which is needed to searched. It gets the visit Object from the Id
     * given by the User and the respective visit Object is redirects to the Search visit page to
     * display the Details of the respective visit Object or redirects to Error page if any error
     * occurs. This method returns the value as ModelAndView Class Object.
     * </p>
     *
     * @param visitId Integer with visitId value from which the visit Object is obtained from the
     *                Database.
     * @param session HttpSession which is used to set the Patient Object to session level.
     * @return ModelAndView Object which redirects to the Search visit Page with the visit Object or to
     *         the Error Page.
     */
    @RequestMapping(value = Constants.SEARCH_VISIT, method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView searchVisit(final HttpSession session, @RequestParam(Constants.ID) final Integer visitId) {

        try {
            final Visit visit = visitService.getVisitById(visitId);
            session.setAttribute(Constants.PATIENT_OBJECT, visit.getPatient());
            return new ModelAndView(Constants.SEARCH_VISIT_JSP, Constants.VISIT_OBJECT, visit);
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_SEARCH_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is displayVisits and this is the Get method which
     * gets all the visit Object Details and is displayed to the user. It is redirected to the Display
     * visit page or to the Error page if any error occurs.This method returns the value as ModelAndView
     * Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the DisplayVisit Page with the visitObject List or
     *         to the Error Page.
     */
    @RequestMapping(value = Constants.DISPLAY_VISITS, method = RequestMethod.GET)
    private ModelAndView displayAllVisits() {
        try {
            final List<Visit> visits = visitService.getVisits();
            return new ModelAndView(Constants.DISPLAY_VISIT_JSP, Constants.VISIT_OBJECTS, visits);
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_DISPLAY_FAILED);
        }
    }

     /**
     * <p>
     * This method is called when the request value is displayVisits and this  
     * is the Get method which gets all the visit Object Details and is
     * displayed to the user. It is redirected to the Display visit page or
     * to the Error page if any error occurs.This method returns the value as 
     * ModelAndView Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the DisplayVisit Page
     *                      with the visitObject List or to the Error Page.
     */
    @RequestMapping(value = Constants.PHYSICIAN_VISITS, method = RequestMethod.GET)
    private ModelAndView displayVisitByPhysicianId(@RequestParam(Constants.ID) final Integer physicianId) {
        try {
            final List<Visit> visits = visitService.getVisitsByPhysicianId(physicianId);
            return new ModelAndView(Constants.PHYSICIAN_DISPLAY_VISIT_JSP, Constants.VISIT_OBJECTS, visits);
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_DISPLAY_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is search Visit and this is the Get method which
     * gets the visit Object Details which is needed to searched. It gets the visit Object from the Id
     * given by the User and the respective visit Object is redirects to the Search visit page to
     * display the Details of the respective visit Object or redirects to Error page if any error
     * occurs. This method returns the value as ModelAndView Class Object.
     * </p>
     *
     * @param visitId Integer with visitId value from which the visit Object is obtained from the
     *                Database.
     * @param session HttpSession which is used to set the Patient Object to session level.
     * @return ModelAndView Object which redirects to the Search visit Page with the visit Object or to
     *         the Error Page.
     */
    @RequestMapping(value = Constants.SEARCH_VISIT_BY_PATIENTID, method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView searchVisitByPatientId(final Model model, final HttpSession session) {

        try {
            final Patient patient = (Patient) session.getAttribute(Constants.PATIENT_OBJECT);
            if (null != patient ) {
                if (Boolean.FALSE == patient.isActive()) {
                    return new ModelAndView(Constants.RECEPTIONIST_INDEX, Constants.PATIENT_INACTIVE,
                            Constants.PATIENT_INACTIVE_MESSAGE);
                }

                final Visit visit = visitService.getVisitByPatientId(patient.getId());
                if (null != visit) {
                    return new ModelAndView(Constants.CREATE_VISIT_JSP, Constants.VISIT_OBJECT, visit);
                } else {
                    return getVisitDetailsFromUser(model);
                }
            } else {
                return getVisitDetailsFromUser(model);
            }
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_SEARCH_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is search Visit and this is the Get method which
     * gets the visit Object Details which is needed to searched. It gets the visit Object from the Id
     * given by the User and the respective visit Object is redirects to the Search visit page to
     * display the Details of the respective visit Object or redirects to Error page if any error
     * occurs. This method returns the value as ModelAndView Class Object.
     * </p>
     *
     * @param patientId Integer with patientId value from which the Patient Object is obtained from the
     *                Database.
     * @param session HttpSession which is used to set the Patient Object to session level.
     * @param model Model Object of the ModelAndView class.
     * @return ModelAndView Object which redirects to the Search visit Page with the visit Object or to
     *         the Error Page.
     */
    @RequestMapping(value = Constants.SEARCH_VISIT_FOR_PATIENT, method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView searchVisitForPatient(final Model model, final HttpSession session,
            @RequestParam(Constants.ID) final Integer patientId) {

        try {
            final Visit visit = visitService.getVisitForPatientId(patientId, session);
            if (null != visit) {
                return new ModelAndView(Constants.CREATE_VISIT_JSP, Constants.VISIT_OBJECT, visit);
            } else {
                return getVisitDetailsFromUser(model);
            }
        } catch (final ApplicationException e) {
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.VISIT_SEARCH_FAILED);
        }
    }
}