package com.ideas2it.hospitalmanagement.patient.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ideas2it.hospitalmanagement.address.model.Address;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.commons.enums.Gender;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.patient.model.Patient;
import com.ideas2it.hospitalmanagement.patient.service.PatientService;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.ui.Model; 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * PatientController is the controller class for the Patient, which allows
 * the application to execute the data manipulation operations of the
 * Patient Details.
 * <p>
 * The Operations that can be done using this application are Adding a
 * Patient Details, Modifying the Patient Details, Removing the Patient
 * Details, Searching for a Patient details and Displaying the Patient
 * Details.
 * </p>
 * The Patient Controller class is mapped with Controller Annotation of Spring
 * Framework by which the Class is mapped to the Spring MVC.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
@Controller
public class PatientController {

    private PatientService patientService;

    public void setPatientService(final PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * <p>
     * This method is called when the request value is createPatient and this
     * is the Get method, which is used to redirect to the Create Patient page.
     * This method returns the value as ModelAndView Class Object contains the
     * Model having the Patient object with List as Address Object.
     * </p>
     *  @param model a Model object which is used to add the patient as an
     *               attribute to the view Layer.
     * @return ModelAndView Object which redirects to the Create Patient Page.
     */
    @RequestMapping(value = Constants.CREATE_PATIENT, method = RequestMethod.GET)
    public ModelAndView getPatientDetailsFromUser(Model model) {

    	Patient patient = new Patient();
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(new Address());
        addresses.add(new Address());
        patient.setAddresses(addresses);
        model.addAttribute(Constants.GENDERS,Gender.values());
        return new ModelAndView(Constants.CREATE_PATIENT_JSP, Constants.PATIENT_OBJECT
            , patient);
    }

    /**
     * <p>
     * This method is called when the request value is addPatient and this is 
     * the Post method which contains the PatientObject Details is added to the 
     * Database. It redirects to the SearchPatient page to display the Patient
     * when object is successfully added or redirects to the Error page if any 
     * failure in adding the Patient Object to Database.This method returns the 
     * value as ModelAndView Class Object.
     * </p>
     * @param patient Patient Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Search Patient Page
     *         or Error Page.
     */
    @RequestMapping(value = Constants.ADD_PATIENT, method = {RequestMethod.POST
        ,RequestMethod.GET})
    private ModelAndView createPatient(@ModelAttribute(Constants.PATIENT) 
            Patient patient) {

        try {
        	patientService.addPatient(patient);
            return new ModelAndView(Constants.SEARCH_PATIENT_JSP, Constants.
                	PATIENT_OBJECT, patient);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                Constants.PATIENT_ADD_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is modifyPatient and this 
     * is the Get method which gets the Patient Object Details which is needed 
     * to modify. It gets the Patient Object from the Id given by the User and
     * the respective Patient Object is redirects to the Create Patient page.
     * This method returns the value as ModelAndView Class Object.
     * </p>
     * @param patientId Integer with PatientId value from which the Patient
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Create Patient Page
     *                      with the PatientObject or to the Error Page.
     */
    @RequestMapping(value = Constants.MODIFY_PATIENT, method = {RequestMethod.POST
        ,RequestMethod.GET})
    public ModelAndView getPatientToModify(@RequestParam(Constants.ID)
            Integer patientId, Model model) {

        try {
            Patient patient = patientService.getPatientById(patientId);
            model.addAttribute(Constants.GENDERS,Gender.values());
            return new ModelAndView(Constants.CREATE_PATIENT_JSP, Constants.
            		PATIENT_OBJECT, patient);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                Constants.PATIENT_SEARCH_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is updatePatient and this
     * is the Post method which contains the Patient Object Details that needs
     * to be updated in the Database. It redirects to the Search Patient page 
     * to display the Updated Patient Object when successfully Updated or
     * redirects to the Error Page when any failure in Modifing the Patient
     * Object to Database.This method returns the value as ModelAndView Object.
     * </p>
     * @param patient Patient Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Search Patient Page or
     *         to the Error Page.
     */
    @RequestMapping(value = Constants.UPDATE_PATIENT, method = {RequestMethod.POST
        ,RequestMethod.GET})
    private ModelAndView updatePatient(@ModelAttribute(Constants.PATIENT) 
            Patient patient) {

        try {
        	patientService.modifyPatient(patient);
            return new ModelAndView(Constants.SEARCH_PATIENT_JSP, Constants.PATIENT_OBJECT,
            		patient);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                Constants.PATIENT_UPDATE_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is deletePatient and this
     * is the Get method which gets the Patient Object Details which is needed
     * to modify. It gets the Patient Object from the Id given by the User and 
     * the respective Patient Object Status is set to False which is Inactive
     * in the database and redirects to the Display Patient page if
     * successfully done or it redirects to the Error page. This method returns
     * the value as ModelAndView Class Object.
     * </p>
     * @param patientId Integer with patientId value from which the Patient
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Display Patient Page
     *                      with the Patient Object or to the Error Page.
     */
    @RequestMapping(value = Constants.DELETE_PATIENT, method = {RequestMethod.POST
        ,RequestMethod.GET})
    public ModelAndView removePatient(@RequestParam(Constants.ID)
            Integer patientId) {


        try {
        	patientService.removePatient(patientId);
            List<Patient> patients = patientService.getPatients();
            return new ModelAndView(Constants.DISPLAY_PATIENT_JSP, Constants.
                PATIENTS, patients);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                Constants.PATIENT_DELETE_FAILED);
        }        
    }

    /**
     * <p>
     * This method is called when the request value is searchPatient and this
     * is the Get method which gets the Patient Object Details which is needed
     * to searched. It gets the Patient Object from the Id given by the User
     * and the respective Patient Object is redirects to the Search Patient
     * page to display the Details of the respective Patient Object or
     * redirects to Error page if any error occurs. This method returns the
     * value as ModelAndView Class Object.
     * </p>
     * @param patientId Integer with patientId value from which the Patient
     *                   Object is obtained from the Database.

     * @return ModelAndView Object which redirects to the Search Patient Page
     *                      with the Patient Object or to the Error Page.
     */
    @RequestMapping(value = Constants.SEARCH_PATIENT, method = {RequestMethod.POST
        ,RequestMethod.GET})
    public ModelAndView searchPatient(@RequestParam(Constants.ID) 
        Integer patientId, HttpSession session) {

        try {
            Patient patient = patientService.getPatientById(patientId);
            session.setAttribute(Constants.PATIENT_OBJECT, patient);
            return new ModelAndView(Constants.SEARCH_PATIENT_JSP, Constants.
            	PATIENT_OBJECT, patient);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                Constants.PATIENT_SEARCH_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is displayPatients and this  
     * is the Get method which gets all the Patient Object Details and is
     * displayed to the user. It is redirected to the Display Patient page or
     * to the Error page if any error occurs.This method returns the value as 
     * ModelAndView Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the DisplayPatient Page
     *                      with the PatientObject List or to the Error Page.
     */
    @RequestMapping(value = Constants.DISPLAY_PATIENTS, method = RequestMethod.GET)
    private ModelAndView displayAllPatients() {
        try {
            List<Patient> patients = patientService.getPatients();
            return new ModelAndView(Constants.DISPLAY_PATIENT_JSP, Constants.
            		PATIENT_OBJECTS, patients);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                Constants.PATIENT_DISPLAY_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is activatePatient and this 
     * is the Get method which gets the Patient Object Details which needs to 
     * activate. It gets the Patient Object from the Id given by the User and
     * the respective Patient Object is Activated.It redirects to the Search
     * Patient page or redirect to Error page if any error occurs.This method 
     * returns the value as ModelAndView Class Object.
     * </p>
     * @param patientId Integer with PatientId value from which the Patient
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the SearchPatient Page
     *                      with the PatientObject or to the Error Page.
     */
    @RequestMapping(value=Constants.ACTIVATE_PATIENT, method = {RequestMethod.POST
        ,RequestMethod.GET})
    private ModelAndView activatePatient(@RequestParam(Constants.ID)
            Integer patientId) {
        try {
            patientService.activatePatient(patientId);
            List<Patient> patients = patientService.getPatients();
            return new ModelAndView(Constants.DISPLAY_PATIENT_JSP, Constants.
            		PATIENT_OBJECTS, patients);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                Constants.PATIENT_ACTIVATION_FAILED);
        }
    }

}
