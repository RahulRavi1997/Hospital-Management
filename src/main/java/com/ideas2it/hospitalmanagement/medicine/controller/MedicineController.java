package com.ideas2it.hospitalmanagement.medicine.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.medicine.model.Medicine;
import com.ideas2it.hospitalmanagement.medicine.service.MedicineService;
import com.ideas2it.hospitalmanagement.medicine.service.impl.MedicineServiceImpl;

/**
 * <p>
 * MedicineController is a Controller Class, which is used to implement data storage and retrieval
 * operations on Medicine Data.It uses HttpServlets and Spring MVC to be hosted as 
 * a web Application. 
 * </p>
 *
 * @author Santhosh Kumar
 */
@Controller
public class MedicineController {
	
	public MedicineController() throws ApplicationException {
		super();
	}
	
    private MedicineService medicineService = new MedicineServiceImpl();

    /**
     * This Method is used to redirect user to the index page. 
     */  
    @RequestMapping(value="/pharmacy", method=RequestMethod.GET)
    private ModelAndView main() {
         return new ModelAndView("pharmacy");
    }

    /**
     * This Method is used to redirect user to the index page. 
     */
    @RequestMapping(value="/medicine_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("pharmacy");
    }

    /**
     * This Method is used to redirect user to the web page with the form used to create and add a new
     * Medicine.
     *
     * @param model a Model object which is used to add the medicine as an attribute to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value=Constants.CREATE_MEDICINE_MAPPING, method=RequestMethod.GET)
    private ModelAndView createMedicine(Model model) {
        Medicine medicine = new Medicine();
        return new ModelAndView(Constants.CREATE_MEDICINE_JSP, Constants.MEDICINE, medicine);
    }

    /**
     * This Method is used to add a new Medicine after obtaining all the medicine details from the
     * user. Redirects to error page if any error occurs, else redirects to display page for the
     * medicine.
     *
     * @param medicine an Medicine object with all the details of the medicine to be added.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value=Constants.ADD_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView addMedicine(@ModelAttribute Medicine medicine) {
        try {
            if (medicineService.addMedicine(medicine)) {
                return new ModelAndView(Constants.MEDICINE_MAIN_JSP, Constants.
                    MEDICINES, medicineService.retrieveMedicines());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * This Method is used to search for an medicine by the id given by the user. Displays the
     * medicine's details if there is a match.
     *
     * @param id an Integer indicating the id of the medicine to be retrieved.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value=Constants.SEARCH_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView searchMedicine(@RequestParam(Constants.ID) int id, Model model) {
        try {
            Medicine medicine = medicineService.searchMedicine(id);
            model.addAttribute(Constants.ID, id);
            if (null != medicine) {
                return new ModelAndView(Constants.DISPLAY_MEDICINE_JSP, Constants.
                    MEDICINE, medicine);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * This Method is used to remove an existing medicine by Id given by the user.
     *
     * @param idToDelete an Integer indicating the id of the medicine to be deleted.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value=Constants.DELETE_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView deleteMedicine(@RequestParam(Constants.ID) int id) {
        Medicine medicine = null;        
        try {
            medicine = medicineService.searchMedicine(id); 
            if (medicineService.deleteMedicine(medicine)) {
                return new ModelAndView(Constants.MEDICINE_MAIN_JSP, Constants.
                    MEDICINES, medicineService.retrieveMedicines());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * This Method is used to display all details of the medicines.
     * 
     * @param model a Model object which is used to add the medicine as an attribute to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */  
    @RequestMapping(value=Constants.DISPLAY_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView displayMedicines(Model model) {
        try {
            List<Medicine> medicines = medicineService.retrieveMedicines();
            model.addAttribute(Constants.MEDICINES, medicines);            
            return new ModelAndView(Constants.MEDICINE_MAIN_JSP,
                Constants.MEDICINES, medicines);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * Method to update existing medicine Details. Returns true if the entry is modified successfully,
     * else returns false if the entry is not found.
     * </p>
     *
     * @param medicineId an medicine object with the updated details of the medicine.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */ 
    @RequestMapping(value=Constants.UPDATE_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView updateMedicine(@RequestParam(Constants.ID) int id) {
        try {
            Medicine medicine = medicineService.searchMedicine(id);
            return new ModelAndView(Constants.UPDATE_MEDICINE_JSP, Constants.
                MEDICINE, medicine);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * Method to update existing Medicine Details. Returns true if the entry is modified successfully,
     * else returns false if the entry is not found.
     * </p>
     *
     * @param id an Integer indicating the id of the medicine to be modified.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */ 
    @RequestMapping(value=Constants.MODIFY_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView modifyMedicine(@ModelAttribute Medicine medicine) {
        try {
            if (medicineService.updateMedicine(medicine)) {
                return new ModelAndView(Constants.DISPLAY_MEDICINE_JSP, Constants.
                    MEDICINE, medicine);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }
    
    /**
     * This Method is used to restore a deleted medicine. Redirects to display all medicines on
     * successful restoration.
     *
     * @param id an Integer indicating the id of the medicine to be restored or reactivated.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value=Constants.RESTORE_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView restoreMedicine(@RequestParam(Constants.ID) int id, Model model) {
        try {
            if (medicineService.restoreMedicine(id)) {
            	return new ModelAndView(Constants.MEDICINE_MAIN_JSP,
                        Constants.MEDICINES, medicineService.retrieveMedicines());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * This Method is used to display all details of the medicines IN JSON format.
     * 
     * @param model a Model object which is used to add the medicine as an attribute to the
     * view Layer.
     * @return String a String object which is used to redirect to a view such as a jsp page.
     */
    @RequestMapping(value="/searchMedicineByName", produces={"application/json",
        "application/xml"},consumes="application/json",
        headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.GET)
    public @ResponseBody String searchMedicineByName(@RequestParam("name") String name) {
    	String searchedMedicines = null;
    	try {
            List<Medicine> medicines = medicineService.retrieveMedicinesByName(name);
            return new Gson().toJson(medicines);
        } catch (ApplicationException e) {
            Logger.error(e);
        }
        return searchedMedicines;
    }
}
