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
import com.ideas2it.hospitalmanagement.logger.Logger;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

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

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
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
    @RequestMapping("/logoutSuccessful")
    public String redirectAfterLogout(){
	    return "login";
    }

    @RequestMapping("/Access_Denied")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "accessDenied";
    }

    @RequestMapping(value={"/login","/"})
    public String redirectLogin(){
	    return "login";
    }
}
