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
 * PurchaseController is a Controller Class, which is used to implement data storage and retrieval
 * operations on purchase Data.It uses HttpServlets and Spring MVC to be hosted as 
 * a web Application. 
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
  
    /**
     * This Method is used to redirect user to the index page. 
     */ 
    @RequestMapping(value="/purchase_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("index");
    }

    /**
     * <p>
     * This method is used to add more medicines after getting details
     * from the user, store and add that object to the purchaselist.
     * </p>
     */
    @RequestMapping(value="/add_more_medicine", method=RequestMethod.POST)
    private ModelAndView addMedicine(@ModelAttribute Purchase purchase) {
        purchase.getListOfMedicines().add(new PurchaseDetails());
        return new ModelAndView(Constants.CREATE_PURCHASE_JSP, Constants.PURCHASE, purchase);
    }

    /**
     * This Method is used to redirect user to the web page with the form used to create and add a new
     * purchase.
     *
     * @param model a Model object which is used to add the purchase as an attribute to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
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

    /**
     * This Method is used to add a new purchase after obtaining all the purchase details from the
     * user. Redirects to error page if any error occurs, else redirects to display page for the
     * purchase.
     *
     * @param purchase an purchase object with all the details of the purchase to be added.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
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
     * Method to update existing purchase Details. Returns true if the entry is modified successfully,
     * else returns false if the entry is not found.
     * </p>
     *
     * @param purchaseId an purchase object with the updated details of the purchase.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */ 
    @RequestMapping(value=Constants.UPDATE_PURCHASE_MAPPING, method=RequestMethod.POST)
    private ModelAndView updatePurchase(@RequestParam(Constants.ID) int id) {
        try {
            return new ModelAndView(Constants.UPDATE_PURCHASE_JSP, Constants.
                PURCHASE, purchaseService.searchPurchase(id));
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * Method to update existing purchase Details. Returns true if the entry is modified successfully,
     * else returns false if the entry is not found.
     * </p>
     *
     * @param id an Integer indicating the id of the purchase to be modified.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
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
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * This Method is used to display all details of the purchases.
     * 
     * @param model a Model object which is used to add the purchase as an attribute to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
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
     * This Method is used to search for an purchase by the id given by the user. Displays the
     * purchase's details if there is a match.
     *
     * @param id an Integer indicating the id of the purchase to be retrieved.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
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
     * This Method is used to remove an existing purchase by Id given by the user.
     *
     * @param idToDelete an Integer indicating the id of the purchase to be deleted.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
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
    
    /**
     * This Method is used to restore a deleted purchase. Redirects to display all purchases on
     * successful restoration.
     *
     * @param id an Integer indicating the id of the purchase to be restored or reactivated.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
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
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }
}
