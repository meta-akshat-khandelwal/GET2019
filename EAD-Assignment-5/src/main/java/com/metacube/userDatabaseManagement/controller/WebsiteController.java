package com.metacube.userDatabaseManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author Akshat
 *
 */

@Controller
public class WebsiteController {
	/** 
	   * Maps the request with all url starting with /
	   * @redirects to the welcome.jsp page
	   */
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String home() {
	        return "welcome";
	    
	    }
	    

	
}
