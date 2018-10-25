package com.ideas2it.hospitalmanagement.user.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.commons.enums.Role;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.user.service.UserService;

/**
 * <p>
 * User Controller is a Controller Class, which is used authorize the user to access the application
 * and allow them to make modifications to the available data. Provides methods to implement basic
 * user operations like Login, Sign-up and Logout operations. Uses Spring security to implement
 * session Management.
 * </p>
 *
 * @author Rahul Ravi
 * @version 1.0
 */
@Controller
public class UserController {

    private UserService userService = null;

    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return this.userService;
    }


    /**
     * This Method is used to obtain the user Credentials during login and create a new Session.
     *
     * @param email    a String indicating the email Id entered by the user while logging in.
     * @param password a String indicating the password entered by the user while logging in.
     * @param role     a String indicating the role of the user that is logging in.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = Constants.SIGNUP_PATH, method = RequestMethod.POST)
    private ModelAndView createUser(Model model, @RequestParam(Constants.EMAIL) String email,
            @RequestParam(Constants.PASSWORD) String password,
            @RequestParam(value = Constants.ROLE, required = false) String role) {
        try {
            if (null != userService.retrieveUserByEmail(email)) {
                if (null == role) {
                    return new ModelAndView(Constants.LOGIN, Constants.USER_FAIL, Constants.SIGNIN_USER_FAIL_MESSAGE);
                } else {
                    return new ModelAndView(Constants.ADMIN_INDEX, Constants.USER_FAIL, Constants.MESSAGE);
                }
            } else {
                final User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                if (null == role) {
                    user.setRole(Role.ADMIN.toString());
                } else {
                    user.setRole(role);
                }
                if (userService.addUser(user)) {
                    if (null == role) {
                        return new ModelAndView(Constants.LOGIN, Constants.MESSAGE, Constants.SIGN_UP_SUCCESS_MESSAGE);
                    } else {
                        return new ModelAndView(Constants.ADMIN_INDEX, Constants.MESSAGE, Constants.SIGN_UP_SUCCESS_MESSAGE);
                    }
                } else {
                    return new ModelAndView(Constants.LOGIN, Constants.USER_FAIL, Constants.SIGN_UP_FAIL_MESSAGE);
                }

            }
        } catch (final ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.LOGIN_JSP, Constants.SIGN_UP_FAIL, Constants.USER_ADD_EXCEPTION);
        }
    }

    /**
     * This Method is used to display all details of the users in JSON format.
     * 
     * @param model a model Object to which the parameters are added to be sent to the view Layer.
     * @param query a String indicating the query that is to be satisfied which searching the database.
     * @return String a String object which is used to redirect or send text output.
     */
    @RequestMapping(value = Constants.DISPLAY_USERS_MAPPING, produces = { Constants.JSON_TYPE,
            Constants.XML_TYPE }, consumes = Constants.JSON_TYPE, headers = Constants.FORM_HEADER, method = RequestMethod.GET)
    private @ResponseBody String displayAllUsers(Model model, @RequestParam(Constants.QUERY) String query) {
        try {
            return new Gson().toJson(userService.retrieveUsersByQuery(query, Role.PHYSICIAN.toString()));
        } catch (ApplicationException e) {
            Logger.error(e);
            return null;
        }
    }

    /**
     * This Method is used to display details of single user in json Format.
     * 
     * @param model a model Object to which the parameters are added to be sent to the view Layer.
     * @param email a String indicating the email that is to be satisfied which searching the database.
     * @return String a String object used to redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = Constants.SEARCH_USER_MAPPING, produces = { Constants.JSON_TYPE,
            Constants.XML_TYPE }, consumes = Constants.JSON_TYPE, headers = Constants.FORM_HEADER, method = RequestMethod.GET)
    private @ResponseBody String searchUser(Model model, @RequestParam(Constants.EMAIL) String email) {
        try {
            return new Gson().toJson(userService.retrieveUsersByQuery(email, Role.ADMIN.toString()));
        } catch (ApplicationException e) {
            Logger.error(e);
            return null;
        }
    }

    /**
     * This Method is used to redirect user to respective login pages based on their roles
     * 
     * @param model     a model Object to which the parameters are added to be sent to the view Layer.
     * @param principal a Principal object that is used to authorize the user.
     * @param request   a HttpServletRequest object from which session attributes are modified.
     * @return String a String object which is used to redirect or send text output.
     */
    @RequestMapping(value = Constants.INDEX_MAPPING, method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal, HttpServletRequest request) {
        model.addAttribute(Constants.EMAIL, principal.getName());
        HttpSession oldSession = request.getSession(Boolean.FALSE);
        if (null != oldSession) {
            oldSession.invalidate();
        }
        HttpSession session = request.getSession();
        session.setAttribute(Constants.EMAIL, principal.getName());
        session.setMaxInactiveInterval(Constants.SESSION_ACTIVE_INTERVAL);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
                .getContext().getAuthentication().getAuthorities();
        if (authorities.iterator().next().toString().equals(Constants.ADMIN_ROLE)) {
            session.setAttribute(Constants.ROLE, Constants.ADMIN_INDEX);
            return Constants.ADMIN_INDEX;
        } else if (authorities.iterator().next().toString().equals(Constants.PHYSICIAN_ROLE)) {
            session.setAttribute(Constants.ROLE, Constants.PHYSICIAN_INDEX);
            try {
                session.setAttribute(Constants.ID,(userService.retrieveUserByEmail(principal.getName()).getId()));
            } catch (ApplicationException e){
                return  Constants.LOGIN_JSP;
            }
            return Constants.PHYSICIAN_INDEX;
        } else if (authorities.iterator().next().toString().equals(Constants.NURSE_ROLE)) {
            session.setAttribute(Constants.ROLE, Constants.NURSE_INDEX);
            try {
                session.setAttribute("inpatients", userService.getAllVisitsByPatientType("InPatient"));
            } catch (ApplicationException e){
                return  Constants.LOGIN_JSP;
            }
            return Constants.NURSE_INDEX;
        } else if (authorities.iterator().next().toString().equals(Constants.RECEPTIONIST_ROLE)) {
            session.setAttribute(Constants.ROLE, Constants.RECEPTIONIST_INDEX);
            return Constants.RECEPTIONIST_INDEX;
        } else {
            return Constants.ACCESS_DENIED_JSP;
        }
    }

    /**
     * This Method is used to display all details of the users.
     * 
     * @param model     a model Object to which the parameters are added to be sent to the view Layer.
     * @param principal a Principal object that is used to authorize the user.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(Constants.ACCESS_DENIED_MAPPING)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute(Constants.EMAIL, principal.getName());
        }
        return Constants.ACCESS_DENIED_JSP;
    }

    /**
     * This Method is used to redirect the user to Login page.
     * 
     * @param model     a model Object to which the parameters are added to be sent to the view Layer.
     * @param principal a Principal object that is used to authorize the user.
     * @param request   a HttpServletRequest object from which session attributes are modified.
     * @param response  a HttpServletResponse object which is used to redirect or send text output.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = { Constants.LOGIN_PATH, Constants.EMPTY_URI, Constants.LOGOUT_PATH,
            Constants.LOGOUT_SUCCESS_MAPPING })
    public String redirectLogin(Model model, Principal principal, HttpServletRequest request,
            HttpServletResponse response) {
        if (principal == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            return Constants.LOGIN;
        } else {
            return userInfo(model, principal, request);
        }
    }

    /**
     * This Method is used to redirect user to Create User Jsp.
     * 
     * @param model a model Object to which the parameters are added to be sent to the view Layer.
     * @return String a String indicating the view for User Creation.
     */
    @RequestMapping(value = Constants.CREATE_USER_MAPPING)
    public String redirectCreateUser(Model model) {
        model.addAttribute(Constants.ROLES, Role.values());
        model.addAttribute(Constants.USER, new User());
        return Constants.CREATE_USER_JSP;
    }

    /**
     * This Method is used to display all details of the users.
     * 
     * @param model a model Object to which the parameters are added to be sent to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = Constants.DISPLAY_USER_MAPPING, method = RequestMethod.GET)
    private ModelAndView displayAllUsers(Model model) {
        try {
            List<User> users = userService.retrieveAllUsers();
            model.addAttribute(Constants.NUMBER_OF_USERS, users.size());
            return new ModelAndView(Constants.USER_DISPLAY_JSP, Constants.USERS, users);
        } catch (ApplicationException e) {
            Logger.error(e);
            return null;
        }
    }

    /**
     * This Method is used to restore a deleted user. Redirects to display all users on successful
     * restoration.
     * 
     * @param id    an Integer indicating the id of the user to be restored.
     * @param model a model Object to which the parameters are added to be sent to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = Constants.RESTORE_USER_MAPPING, method = RequestMethod.POST)
    private ModelAndView restoreUser(@RequestParam(Constants.ID) int id, Model model) {
        try {
            if (userService.restoreUser(id)) {
                model.addAttribute(Constants.MESSAGE, Constants.USER_RESTORE_SUCCESS_MESSAGE);
                return new ModelAndView(Constants.DISPLAY_USER_JSP, Constants.USERS, userService.retrieveAllUsers());
            } else {
                return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.USER_EDIT_EXCEPTION);
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_RESTORE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * Method to update existing User Details. Returns true if the entry is modified successfully, else
     * returns false if the entry is not found.
     * </p>
     * 
     * @param id    an Integer indicating the id of the user to be modified.
     * @param model a model Object to which the parameters are added to be sent to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = Constants.MODIFY_USER_MAPPING, method = RequestMethod.GET)
    private ModelAndView modifyUser(@RequestParam(Constants.ID) int id, Model model) {
        try {
            model.addAttribute(Constants.ROLES, Role.values());
            return new ModelAndView(Constants.CREATE_USER_JSP, Constants.USER, userService.retrieveUserById(id));
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_EDIT_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * Method to update existing User Details. Returns true if the entry is modified successfully, else
     * returns false if the entry is not found.
     * </p>
     * 
     * @param user  an User object with the updated details of the user.
     * @param model a model Object to which the parameters are added to be sent to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = Constants.UPDATE_USER_MAPPING, method = RequestMethod.POST)
    private ModelAndView updateUser(@ModelAttribute final User user, final Model model) {

        try {
            if (!userService.modifyUser(user)) {
                return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.EDIT_FAILED);
            }
            model.addAttribute(Constants.MESSAGE, Constants.USER_UPDATE_SUCCESS_MESSAGE);
            return new ModelAndView(Constants.DISPLAY_USER_JSP, Constants.USERS, userService.retrieveAllUsers());
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_EDIT_EXCEPTION, user.getId()));
        }
    }

    /**
     * This Method is used to remove an existing user by Id given by the user.
     * 
     * @param idToDelete an Integer indicating the id of the user to be deleted.
     * @param model      a model Object to which the parameters are added to be sent to the view Layer.
     * @return modelAndView a ModelAndView object which is used to add attributes to a model and
     *         redirect it to a view such as a jsp page.
     */
    @RequestMapping(value = Constants.DELETE_USER_MAPPING, method = RequestMethod.POST)
    private ModelAndView removeUser(@RequestParam(Constants.ID) int idToDelete, Model model) {
        try {
            if (!userService.deleteUser(idToDelete)) {
                return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE, Constants.USER_DELETE_EXCEPTION);
            }
            model.addAttribute(Constants.MESSAGE, Constants.USER_DELETE_SUCCESS_MESSAGE);
            return new ModelAndView(Constants.DISPLAY_USER_JSP, Constants.USERS, userService.retrieveAllUsers());
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR_MESSAGE,
                    String.format(Constants.USER_DELETE_EXCEPTION, idToDelete));
        }
    }
}
