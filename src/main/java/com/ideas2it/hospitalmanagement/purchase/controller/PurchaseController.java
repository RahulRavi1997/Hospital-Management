package com.ideas2it.hospitalmanagement.purchase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.purchase.model.Purchase;
import com.ideas2it.hospitalmanagement.purchaseDetails.model.PurchaseDetails;
import com.ideas2it.hospitalmanagement.purchase.service.impl.PurchaseServiceImpl;
import com.ideas2it.hospitalmanagement.purchase.service.PurchaseService;

/**
 * <p>
 * This class acts as a controller and perform operations with 
 * the purchase details.
 * </p>
 *
 * @author Santhosh Kumar
 */
@Controller
public class PurchaseController {
	
	public PurchaseController() throws ApplicationException {
		super();
	}
	
    private PurchaseService purchaseService = new PurchaseServiceImpl();
  
    @RequestMapping(value="/purchase_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("index");
    }

    @RequestMapping(value="/add_more_medicine", method=RequestMethod.POST)
    private ModelAndView addMedicine(@ModelAttribute Purchase purchase) {
        purchase.getListOfMedicines().add(new PurchaseDetails());
        return new ModelAndView(Constants.CREATE_PURCHASE_JSP, Constants.PURCHASE, purchase);
    }

    /**
     * <p>
     * This method is used to add a new purchase after getting details
     * from the user, store and add that object to the purchaselist.
     * </p>
     */
    @RequestMapping(value=Constants.CREATE_PURCHASE_MAPPING, method=RequestMethod.GET)
    private ModelAndView createPurchase(Model model) {
        Purchase purchase = new Purchase();
        List<PurchaseDetails> listOfMedicines = new ArrayList<PurchaseDetails>();
        PurchaseDetails purchaseDetails = new PurchaseDetails();
        listOfMedicines.add(purchaseDetails);
        purchase.setListOfMedicines(listOfMedicines);
        return new ModelAndView(Constants.CREATE_PURCHASE_JSP, Constants.PURCHASE, purchase);
    }

    @RequestMapping(value=Constants.ADD_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView addPurchase(@ModelAttribute Purchase purchase) {
        try {
            if (purchaseService.addPurchase(purchase)) {
                for (PurchaseDetails purchaseDetails : purchase.getListOfMedicines()) {
                    purchaseService.updateMedicine(purchaseDetails); 
                }
                return new ModelAndView(Constants.PURCHASE_MAIN_JSP, Constants.
                            PURCHASES, purchaseService.retrievePurchases()); 
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
     * This method is used to update the details of a particular purchase and 
     * send it to modify in the purchase list.
     * </p>
     */
    @RequestMapping(value=Constants.UPDATE_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView updatePurchase(@RequestParam(Constants.ID) int id) {
        try {
            return new ModelAndView(Constants.UPDATE_PURCHASE_JSP, Constants.
                PURCHASE, purchaseService.searchPurchase(id));
        } catch (ApplicationException e) {
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * This method is used to modify the purchase details and
     * update its details.
     * </p>
     */
    @RequestMapping(value=Constants.MODIFY_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView modifyPurchase(@ModelAttribute Purchase purchase) {
        try {
            if (purchaseService.updatePurchase(purchase)) {
                return new ModelAndView(Constants.DISPLAY_PURCHASE_JSP, Constants.
                    PURCHASE, purchase);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * This method is used to display the purchases that are being done
     * by the employees.
     * </p>
     */
    @RequestMapping(value=Constants.DISPLAY_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView displayPurchases() {
        try {
            return new ModelAndView(Constants.PURCHASE_MAIN_JSP,
                Constants.PURCHASES, purchaseService.retrievePurchases());
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * This method is used to search the particular
     * purchase from the purchase list.
     * </p>
     */
    @RequestMapping(value=Constants.SEARCH_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView searchPurchase(@RequestParam(Constants.ID) int id, Model model) {
        try {
            Purchase purchase  = purchaseService.searchPurchase(id);
            model.addAttribute(Constants.ID, id);
            if (null != purchase) {
                return new ModelAndView(Constants.DISPLAY_PURCHASE_JSP, Constants.
                    PURCHASE, purchase);
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
     * This method is used to delete all the purchase details from the 
     * purchase list.
     * </p>
     */
    @RequestMapping(value=Constants.DELETE_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView deletePurchase(@RequestParam(Constants.ID) int id) {
        Purchase purchase = null;        
        try {
            purchase = purchaseService.searchPurchase(id); 
            if (purchaseService.deletePurchase(purchase)) {
                return new ModelAndView(Constants.PURCHASE_MAIN_JSP, Constants.
                    PURCHASES, purchaseService.retrievePurchases());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }
    
    @RequestMapping(value=Constants.RESTORE_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView restorePurchase(@RequestParam(Constants.ID) int id, Model model) {
        try {
            if (purchaseService.restorePurchase(id)) {
            	return new ModelAndView(Constants.PURCHASE_MAIN_JSP,
                        Constants.PURCHASES, purchaseService.retrievePurchases());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            return new ModelAndView(Constants.ERROR);
        }
    }
}
