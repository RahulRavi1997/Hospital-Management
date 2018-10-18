package com.ideas2it.hospitalmanagement.user.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.commons.enums.Role;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.visit.service.VisitService;
import com.ideas2it.hospitalmanagement.visit.service.impl.VisitServiceImpl;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.user.service.UserService;


/**
 * <p>
 * User Controller is a Controller Class, which is used authorise the user to
 * access the application and allow them to make modifications to the
 * available data. Provides methods to implement basic user operations like
 * Login, Signup and Logout operations.
 * </p>
 * @author    Rahul Ravi
 * @version   1.0
 */
@Controller
public class UserController {

    private UserService userService = null;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return this.userService;
    }

    private VisitService visitService = null;

    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    public VisitService getVisitService() {
        return this.visitService;
    }

    /**
     * This Method is used to obtain the user Credentials during login and
     * create a new Session.
     *
     * @param email a String indicating the email Id entered by the user while
     *              logging in.
     *
     * @param password a String indicating the password entered by the user while
     *                 logging in.
     *
     * @param role a String indicating the role of the user that is logging in.
     */
    @RequestMapping(value=Constants.SIGNUP_PATH,method=RequestMethod.POST)
    private ModelAndView createUser(Model model, @RequestParam(Constants.EMAIL) String email,
                            @RequestParam(Constants.PASSWORD) String password,
                            @RequestParam(value=Constants.ROLE, required=false) String role) {
        try {
            if (null != userService.retrieveUserByEmail(email)) {
                return new ModelAndView(Constants.LOGIN, Constants.USER_FAIL, Constants.SIGNIN_USER_FAIL_MESSAGE);
            } else {
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                if (null == role) {
                    user.setRole(Role.ADMIN.toString());
                    if (userService.addUser(user)) {
                        return new ModelAndView(Constants.LOGIN, Constants.SIGN_UP_SUCCESS, Constants.SIGN_UP_SUCCESS_MESSAGE);
                    } else {
                        return new ModelAndView(Constants.LOGIN, Constants.SIGN_UP_FAIL, Constants.SIGN_UP_FAIL_MESSAGE);
                    }
                } else {
                	user.setRole(role);
                    if (userService.addUser(user)) {
                        model.addAttribute(Constants.MESSAGE, Constants.SIGN_UP_SUCCESS_MESSAGE);
                        return new ModelAndView(Constants.ADMIN, Constants.SIGN_UP_SUCCESS, Constants.SIGN_UP_SUCCESS_MESSAGE);
                    } else {
                        return new ModelAndView(Constants.LOGIN, Constants.SIGN_UP_FAIL, Constants.SIGN_UP_FAIL_MESSAGE);
                    }
                }
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.LOGIN_JSP, Constants.SIGN_UP_FAIL, Constants.USER_ADD_EXCEPTION);
        }
    }

    /**
     * This Method is used to display all details of the users.
     *
     * @return response a HttpServletResponse object which is used to redirect
     *                 or send text output.
     */
    @RequestMapping(value="displayUserAutocomplete", produces={"application/json",
   	"application/xml"},consumes="application/json",headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.GET)
    private @ResponseBody String displayAllUsers(Model model, @RequestParam("query") String query) {
        try {
        	return new Gson().toJson(userService.retrieveUsersByQuery(query, Role.PHYSICIAN.toString()));
        } catch (ApplicationException e) {
            Logger.error(e);
            return null;
        }
    }

    @RequestMapping(value="/searchUser", produces={"application/json",
   	"application/xml"},consumes="application/json",headers = "content-type=application/x-www-form-urlencoded", method = RequestMethod.GET)
    private @ResponseBody String searchUser(Model model, @RequestParam(Constants.EMAIL) String email) {
        try {
        	return new Gson().toJson(userService.retrieveUsersByQuery(email, Role.ADMIN.toString()));
        } catch (ApplicationException e) {
            Logger.error(e);
            return null;
        }
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal, HttpServletRequest request) {
        model.addAttribute("email",principal.getName());
        HttpSession oldSession = request.getSession(Boolean.FALSE);
        if (null != oldSession) {
            oldSession.invalidate();
        }
        HttpSession session = request.getSession();
        session.setAttribute(Constants.EMAIL, principal.getName());
        session.setMaxInactiveInterval(Constants.SESSION_ACTIVE_INTERVAL);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if (authorities.iterator().next().toString().equals("ROLE_ADMIN")) {
            session.setAttribute("Role","Admin");
            return "admin";
        } else if (authorities.iterator().next().toString().equals("ROLE_PHYSICIAN")) {
            session.setAttribute("Role","Physician");
            return "physician";
        } else if (authorities.iterator().next().toString().equals("ROLE_NURSE")) {
            try {
            session.setAttribute("Role","Nurse");
            session.setAttribute("inpatients",visitService.getVisitsByPatientType("InPatient"));
            return "nurseHome"; 
		}
            catch(ApplicationException e) {
		
		}
 	return "accessDenied";
        } else if (authorities.iterator().next().toString().equals("ROLE_RECEPTIONIST")) {
            session.setAttribute("Role","Receptionist");
            return "receptionist";
        } else {
            return "accessDenied";
        }
    }
    @RequestMapping("/Access_Denied")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("message",
                    "You do not have permission to access this page!");
        }
        return "accessDenied";
    }

    @RequestMapping(value={"/login","/","/logoutSuccessful"})
    public String redirectLogin(Model model, Principal principal, HttpServletRequest request){
        if (principal == null) {
	        return "login";
        } else {
        	return userInfo(model, principal, request);
        }
    }

    @RequestMapping(value="/createUser")
    public String redirectCreateUser(Model model){
    	model.addAttribute("roles", Role.values());
    	model.addAttribute(Constants.USER, new User());
	    return "CreateUser";
    }
    
    /**
     * This Method is used to display all details of the users.
     *
     * @return response a HttpServletResponse object which is used to redirect
     *                 or send text output.
     */
    @RequestMapping(value=Constants.DISPLAY_USER_MAPPING, method = RequestMethod.GET)
    private ModelAndView displayAllUsers(Model model) {
        try {
        	List<User> users = userService.retrieveAllUsers();
        	model.addAttribute("numberOfUsers", users.size());
        	return new ModelAndView("DisplayUsers", "users", users);
        } catch (ApplicationException e) {
            Logger.error(e);
            return null;
        }
    }
    /**
     * This Method is used to restore a deleted user. Redirects to display
     * all users on successful restoration.
     *
     * @param id an Integer indicating the id of the user to be restored or
     *           reactivated.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.RESTORE_USER_MAPPING, method=RequestMethod.POST)
    private ModelAndView restoreUser(@RequestParam(Constants.ID) int id, Model model) {
        try {
            if (userService.restoreUser(id)) {
                model.addAttribute(Constants.MESSAGE, Constants.USER_RESTORE_SUCCESS_MESSAGE);
                return new ModelAndView(Constants.DISPLAY_USER_JSP, Constants.
                        USERS, userService.retrieveAllUsers());
            } else {
                return new ModelAndView(Constants.ERROR_JSP, Constants.
                        ERROR_MESSAGE, Constants.USER_EDIT_EXCEPTION);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_RESTORE_EXCEPTION, id));
        }
    }

    /**
     *  <p>
     *  Method to update existing User Details. Returns true if the entry
     *  is modified successfully, else returns false if the entry is not found.
     *  </p>
     *
     * @param id an Integer indicating the id of the user to be modified.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.MODIFY_USER_MAPPING, method=RequestMethod.GET)
    private ModelAndView modifyUser(@RequestParam(Constants.ID) int id, Model model) {
        try {
        	model.addAttribute("roles", Role.values());
            return new ModelAndView(Constants.CREATE_USER_JSP, Constants.
                    USER, userService.retrieveUserById(id));
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_EDIT_EXCEPTION, id));
        }
    }

    /**
     *  <p>
     *  Method to update existing User Details. Returns true if the entry
     *  is modified successfully, else returns false if the entry is not found.
     *  </p>
     *
     * @param user an User object with the updated details of the
     *                 user.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.UPDATE_USER_MAPPING, method=RequestMethod.POST)
    private ModelAndView updateUser(@ModelAttribute User user, Model model) {

        try {
            if (!userService.modifyUser(user)) {
                return new ModelAndView(Constants.ERROR_JSP, Constants.
                        ERROR_MESSAGE, Constants.EDIT_FAILED);
            }
            model.addAttribute(Constants.MESSAGE, Constants.USER_UPDATE_SUCCESS_MESSAGE);
            return new ModelAndView(Constants.DISPLAY_USER_JSP, Constants.
                    USERS, userService.retrieveAllUsers());
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_EDIT_EXCEPTION, user.getId()));
        }

    }

    /**
     * This Method is used to remove an existing user by Id given by the
     * user.
     *
     * @param idToDelete an Integer indicating the id of the user to be
     *                   deleted.
     *
     * @return modelAndView a ModelAndView object which is used to add
     *                       attributes to a model and redirect it to a view
     *                       such as a jsp page.
     */
    @RequestMapping(value=Constants.DELETE_USER_MAPPING, method=RequestMethod.POST)
    private ModelAndView removeUser(@RequestParam(Constants.ID) int idToDelete, Model model) {
        try {
            if (!userService.deleteUser(idToDelete)) {
                return new ModelAndView(Constants.ERROR_JSP, Constants.
                        ERROR_MESSAGE, Constants.USER_DELETE_EXCEPTION);
            }
            model.addAttribute(Constants.MESSAGE, Constants.USER_DELETE_SUCCESS_MESSAGE);
            return new ModelAndView(Constants.DISPLAY_USER_JSP, Constants.
                    USERS, userService.retrieveAllUsers());
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_DELETE_EXCEPTION, idToDelete));
        }
    }
}
