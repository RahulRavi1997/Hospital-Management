package com.ideas2it.hospitalmanagement.pharmacy.controller;

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
import com.ideas2it.hospitalmanagement.pharmacy.model.Item;
import com.ideas2it.hospitalmanagement.pharmacy.service.ItemService;
import com.ideas2it.hospitalmanagement.pharmacy.service.impl.ItemServiceImpl;

/**
 * <p>
 * This class is acts as a controller and perform operations 
 * with the Item details.
 * </p>
 *
 * @author Santhosh Kumar
 */
@Controller
public class ItemController {
	
	public ItemController() throws ApplicationException {
		super();
	}
	
    private ItemService itemService = new ItemServiceImpl();

    @RequestMapping(value="/pharmacy", method=RequestMethod.GET)
    private ModelAndView main() {
         return new ModelAndView("index");
    }

    @RequestMapping(value="/item_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("index");
    }

    @RequestMapping(value=Constants.CREATE_ITEM_MAPPING, method=RequestMethod.GET)
    private ModelAndView createItem(Model model) {
        Item item = new Item();
        return new ModelAndView(Constants.CREATE_ITEM_JSP, Constants.ITEM, item);
    }

    @RequestMapping(value=Constants.ADD_ITEM_MAPPING, method=RequestMethod.POST)
    private ModelAndView addItem(@ModelAttribute Item item) {
        try {
            if (itemService.addItem(item)) {
                return new ModelAndView(Constants.ITEM_MAIN_JSP, Constants.
                    ITEMS, itemService.retrieveItems());
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
     * This method is used to search the particular item
     * from the item list and display his details.
     * </p>
     */
    @RequestMapping(value=Constants.SEARCH_ITEM_MAPPING, method=RequestMethod.POST)
    private ModelAndView searchItem(@RequestParam(Constants.ID) int id, Model model) {
        try {
            Item item = itemService.searchItem(id);
            model.addAttribute(Constants.ID, id);
            if (null != item) {
                return new ModelAndView(Constants.DISPLAY_ITEM_JSP, Constants.
                    ITEM, item);
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
     * This method is used to delete all the details of the item
     * from the item list.
     * </p>
     */
    @RequestMapping(value=Constants.DELETE_ITEM_MAPPING, method=RequestMethod.POST)
    private ModelAndView deleteItem(@RequestParam(Constants.ID) int id) {
        Item item = null;        
        try {
            item = itemService.searchItem(id); 
            if (itemService.deleteItem(item)) {
                return new ModelAndView(Constants.ITEM_MAIN_JSP, Constants.
                    ITEMS, itemService.retrieveItems());
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
     * This method is used to display the item that are available for
     * item detail operations.
     * </p>
     */    
    @RequestMapping(value=Constants.DISPLAY_ITEM_MAPPING, method=RequestMethod.POST)
    private ModelAndView displayItems() {
        try {
            return new ModelAndView(Constants.ITEM_MAIN_JSP,
                Constants.ITEMS, itemService.retrieveItems());
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * This method is used to update the item details and send it to
     * modify it in the list.
     * </p>
     */ 
    @RequestMapping(value=Constants.UPDATE_ITEM_MAPPING, method=RequestMethod.POST)
    private ModelAndView updateItem(@RequestParam(Constants.ID) int id) {
        try {
            Item item = itemService.searchItem(id);
            return new ModelAndView(Constants.UPDATE_ITEM_JSP, Constants.
                ITEM, item);
        } catch (ApplicationException e) {
            return new ModelAndView(Constants.ERROR);
        }
    }

    /**
     * <p>
     * This method is used to modify the item details and
     * update his details.
     * </p>
     */  
    @RequestMapping(value=Constants.MODIFY_ITEM_MAPPING, method=RequestMethod.POST)
    private ModelAndView modifyItem(@ModelAttribute Item item) {
        try {
            if (itemService.updateItem(item)) {
                return new ModelAndView(Constants.DISPLAY_ITEM_JSP, Constants.
                    ITEM, item);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR);
        }
    }
}
