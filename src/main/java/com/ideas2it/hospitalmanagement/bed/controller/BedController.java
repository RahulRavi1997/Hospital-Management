package com.ideas2it.hospitalmanagement.bed.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class BedController {
	
	   @RequestMapping(value = "/userInfo", method = RequestMethod.Post)
	    public String userInfo(Model model, Principal principal) {
	        model.addAttribute("email",principal.getName());
	        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	        if (authorities.iterator().next().toString().equals("ROLE_ADMIN")) {
	            return "admin";
	        } else if (authorities.iterator().next().toString().equals("ROLE_DOCTOR")) {
	            return "doctor";
	        } else if (authorities.iterator().next().toString().equals("ROLE_NURSE")) {
	            return "nurse";
	        } else if (authorities.iterator().next().toString().equals("ROLE_RECEPTIONIST")) {
	            return "receptionist";
	        } else {
	            return "accessDenied";
	        }
	    }
	
}