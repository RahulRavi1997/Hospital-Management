package com.ideas2it.hospitalmanagement.itemMaster.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.itemMaster.model.ItemMaster;
import com.ideas2it.hospitalmanagement.itemMaster.service.ItemMasterService;

/**
 * <p>
 * ItemMasterController is a Controller Class, which is used authorise the admin
 * to access the application and allow them to do operations like add
 * medicines,edit etc
 * </p>
 * 
 * @author Hariharasudan K S
 * @version 1.0
 */
@Controller
public class ItemMasterController {
	
	public static final String ADD_ITEM_JSP="addItemsMaster";
   
	private ItemMasterService itemMasterService = null;

	public void setItemMasterService(ItemMasterService itemMasterService) {
		this.itemMasterService = itemMasterService;
	} 

	public ItemMasterService getItemMasterService() {
		return this.itemMasterService;
	}

	/**
	 * This Method is used to redirect user to the webpage with the form used to
	 * create and add a new Medicine Item.
	 * 
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = Constants.VIEW_ALL_ITEMS, method = RequestMethod.GET)
	public ModelAndView viewAllItemMaster() {
		try {
			List<ItemMaster> allItems = itemMasterService.retrieveAllItems();
			return new ModelAndView(Constants.DISPLAY_ITEMS, Constants.ALL_ITEMS, allItems);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.ITEM_DISPLAY_EXCEPTION);
		}
	}

	/**
	 * This Method is used to redirect user to the webpage with the form used to
	 * create and add a new Medicine Item.
	 *
	 * @param model
	 *            a Model object which is used to add the MedicineItem information
	 *            as an attribute to the view Layer.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = Constants.CREATE_ITEM_MASTER, method = RequestMethod.GET)
	private ModelAndView redirectToCreateItem() {
		ItemMaster itemMaster = new ItemMaster();
		return new ModelAndView(ADD_ITEM_JSP, Constants.ITEM_MASTER, itemMaster);
	}

	/**
	 * This Method is used to add a new Item Detail after obtaining all the details
	 * from the physician. Redirects to error page if any error occurs.
	 *
	 * @param item
	 *            an ItemMaster object with all the items information to be added.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = Constants.ADD_ITEM_MASTER_MAPPING, method = RequestMethod.POST)
	private ModelAndView createItem(@ModelAttribute ItemMaster item, ModelAndView model) {
		try {
			if (!itemMasterService.createItem(item)) {
				return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
						Constants.ITEM_ADDITION_EXCEPTION);
			}
			model = viewAllItemMaster();
			return model;
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					    String.format(Constants.ITEM_ADDITION_EXCEPTION, item.getId()));
		}

	}

	/**
	 * <p>
	 * Method to update existing item details. Returns true if the entry is modified
	 * successfully, else returns false if the entry is not found.
	 * </p>
	 *
	 * @param id
	 *            an Integer indicating the id of the item information to be
	 *            modified.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = Constants.EDIT_ITEM_MASTER, method = RequestMethod.GET)
	private ModelAndView redirectToEditItem(@RequestParam(Constants.ID) int id) {
		try {
			return new ModelAndView(Constants.ADD_ITEMS, Constants.ITEM_MASTER, itemMasterService.retrieveItemByName(id));
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					                            String.format(Constants.ITEM_EDIT_EXCEPTION, id));
		}
	}

	/**
	 * This Method is used to update a new Item Detail after obtaining all the new
	 * details Redirects to error page if any error occurs.
	 *
	 * @param item
	 *            an Item object with all the items information to be added.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */

	@RequestMapping(value = Constants.UPDATE_ITEM_MASTER_MAPPING, method = RequestMethod.POST)
	private ModelAndView updateItemMaster(@ModelAttribute ItemMaster item, ModelAndView model) {
		try {
			if (!itemMasterService.modifyItem(item)) {
				return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.EDIT_FAILED);
			}
			model = viewAllItemMaster();
			return model;
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					                 String.format(Constants.ITEM_EDIT_EXCEPTION, item.getId()));
		}

	}
}
