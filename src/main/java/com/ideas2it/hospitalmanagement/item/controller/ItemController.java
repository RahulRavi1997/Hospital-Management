package com.ideas2it.hospitalmanagement.item.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.item.model.Item;
import com.ideas2it.hospitalmanagement.item.service.ItemService;

/**
 * <p>
 * User Controller is a Controller Class, which is used authorise the user to
 * access the application and allow them to make modifications to the available
 * data. Provides methods to implement basic user operations like Login, Signup
 * and Logout operations.
 * </p>
 * 
 * @author Hariharasudan K S
 * @version 1.0
 */
@Controller
public class ItemController {


	private ItemService itemService = null;

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public ItemService getItemService() {
		return this.itemService;
	}

	/**
	 * This Method is used to display items from database and show client view.
	 *
	 * @param model a Model object which is used to add the diagnosis information as
	 *              an attribute to the view Layer.
	 * @return modelAndView a ModelAndView object which is used to add attributes to
	 *         a model and redirect it to a view such as a jsp page.
	 */
	@RequestMapping(value = Constants.VIEW_ITEMS, method = RequestMethod.GET)
	public ModelAndView viewAllItems() {
		try {
			List<Item> allItems = itemService.retrieveAllItems();
			return new ModelAndView(Constants.DISPLAY_ALL_ITEMS, Constants.DISPLAY_ALL_ITEMS, allItems);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.ITEM_DISPLAY_EXCEPTION);
		}
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
	@RequestMapping(value = Constants.CREATE_ITEM, method = RequestMethod.GET)
	private ModelAndView redirectToCreateItem() {
		Item item = new Item();
		return new ModelAndView(Constants.CREATE_ITEM_JSP, Constants.ITEM, item);
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
	@RequestMapping(value = Constants.ADD_ITEM_MAPPING, method = RequestMethod.POST)
	private ModelAndView createItem(@ModelAttribute Item item, Model model) {
		try {
			if (!itemService.createItem(item)) {
				return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
						Constants.ITEM_ADDITION_EXCEPTION);
			}
			model.addAttribute(Constants.MESSAGE, Constants.ITEM_ADD_SUCCESS_MESSAGE);
			return new ModelAndView(Constants.SEARCH_DIAGNOSIS_JSP, Constants.ITEM, item);
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					String.format(Constants.ITEM_ADDITION_EXCEPTION, item.getId()));
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
	@RequestMapping(value = Constants.EDIT_ITEM_MAPPING, method = RequestMethod.GET)
	private ModelAndView redirectToEditItem(@RequestParam(Constants.ID) int id) {
		try {
			return new ModelAndView(Constants.CREATE_ITEM_JSP, Constants.DIAGNOSIS, itemService.retrieveItemById(id));
		} catch (ApplicationException e) {
			return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
					String.format(Constants.ITEM_EDIT_EXCEPTION, id));
		}
	}

}
