package com.ideas2it.hospitalmanagement.user.controller;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.commons.enums.Role;
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.user.service.impl.UserServiceImpl;
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
                            @RequestParam(Constants.PASSWORD) String password) {
        try {
            if (null != userService.retrieveUserByEmail(email)) {
                return new ModelAndView(Constants.LOGIN, Constants.USER_FAIL, Constants.SIGNIN_USER_FAIL_MESSAGE);
            } else {
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setRole(Role.ADMIN.toValue());
                if (userService.addUser(user)) {
                    model.addAttribute(Constants.SIGNIN_EMAIL, email);
                    return new ModelAndView(Constants.LOGIN, Constants.SIGN_UP_SUCCESS, Constants.SIGN_UP_SUCCESS_MESSAGE);
                } else {
                    return new ModelAndView(Constants.LOGIN, Constants.SIGN_UP_FAIL, Constants.SIGN_UP_FAIL_MESSAGE);
                }
            }
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.LOGIN_JSP, Constants.SIGN_UP_FAIL, Constants.USER_ADD_EXCEPTION);
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        model.addAttribute("email",principal.getName());
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if (authorities.iterator().next().toString().equals("ROLE_ADMIN")) {
            return "admin";
        } else if (authorities.iterator().next().toString().equals("ROLE_PHYSICIAN")) {
            return "physician";
        } else if (authorities.iterator().next().toString().equals("ROLE_NURSE")) {
            return "nurse";
        } else if (authorities.iterator().next().toString().equals("ROLE_RECEPTIONIST")) {
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
    public String redirectLogin(Model model, Principal principal){
        if (principal == null) {
	        return "login";
        } else {
        	return userInfo(model, principal);
        }
    }
}
