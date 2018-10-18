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
 * This class is acts as a controller and perform operations 
 * with the Medicine details.
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

    @RequestMapping(value="/pharmacy", method=RequestMethod.GET)
    private ModelAndView main() {
         return new ModelAndView("index");
    }

    @RequestMapping(value="/medicine_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("index");
    }

    @RequestMapping(value=Constants.CREATE_MEDICINE_MAPPING, method=RequestMethod.GET)
    private ModelAndView createMedicine(Model model) {
        Medicine medicine = new Medicine();
        return new ModelAndView(Constants.CREATE_MEDICINE_JSP, Constants.MEDICINE, medicine);
    }

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
     * <p>
     * This method is used to search the particular medicine
     * from the medicine list and display his details.
     * </p>
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
     * <p>
     * This method is used to delete all the details of the medicine
     * from the medicine list.
     * </p>
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
     * <p>
     * This method is used to display the medicine that are available for
     * medicine detail operations.
     * </p>
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
     * This method is used to update the medicine details and send it to
     * modify it in the list.
     * </p>
     */ 
    @RequestMapping(value=Constants.UPDATE_MEDICINE_MAPPING, method=RequestMethod.POST)
    private ModelAndView updateMedicine(@RequestParam(Constants.ID) int id) {
        try {
            Medicine medicine = medicineService.searchMedicine(id);
            return new ModelAndView(Constants.UPDATE_MEDICINE_JSP, Constants.
                MEDICINE, medicine);
        } catch (ApplicationException e) {
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * This method is used to modify the medicine details and
     * update his details.
     * </p>
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
            return new ModelAndView(Constants.ERROR);
        }
    }

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
