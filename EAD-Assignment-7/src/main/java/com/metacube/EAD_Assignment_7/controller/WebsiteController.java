
package com.metacube.EAD_Assignment_7.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.metacube.EAD_Assignment_7.model.Admin;
import com.metacube.EAD_Assignment_7.service.implementation.AdminService;

@Controller
public class WebsiteController {
	@Autowired
	AdminService adminService;
	
	/** 
	   * Maps the request with all url starting with /welcome
	   * @redirects to the welcome.jsp page
	   */
	  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	    public String home() {
	        return "welcome";
	    
	    }
	  
	  /** 
	   * Maps the request with all url starting with /
	   * @redirects to the login.jsp page
	   */
	  @RequestMapping(value ="/", method = RequestMethod.GET)
	  public String login()
	  {
		  return "login";
	  }
	    
	  
	  /** 
	   * Maps the request with all url starting with /loginadmin
	   * @redirects to the welcome.jsp page if success else login.jsp 
	   */
	  @RequestMapping(value ="/loginadmin", method=RequestMethod.GET)
	  public String loginAdmin(Admin admin)
	  {
		  boolean result;
		   try{
			  result=adminService.getAdmin(admin.getId(),admin.getPassword());
			  
			  if(result)
			  {
				  return "welcome";
			  }
			  
			 
			  return "login";
		   }
		   catch(Exception e)
		   {
			   return "login";
		   }
	  }

	
}
