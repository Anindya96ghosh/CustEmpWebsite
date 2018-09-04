package com.rest.CustEmp.CustEmpWebpage.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class CustController {

	RestTemplate restTemplate = new RestTemplate();
	String viewAllCustomers	  = "http://localhost:8080/customers";
	@RequestMapping(value="/viewAllCustomer", method = RequestMethod.GET)
	public String viewAllCustomer(Model model)
	{
		ResponseEntity<?> responseEntity = restTemplate.getForEntity(viewAllCustomers, ArrayList.class); 
  		
		if(responseEntity.getStatusCode().equals(HttpStatus.OK))  
  			model.addAttribute("customers", responseEntity.getBody()); 
  		else 
  			model.addAttribute("customers", null); 
  		return "viewAllCustomer"; 
	}
	
	 @RequestMapping(value="/home", method = RequestMethod.GET)
	    public String showHomePage(Model model){
	        return "home";
	    }
	
	 @RequestMapping(value="", method = RequestMethod.GET)
	    public String showHome(Model model){
	        return "home";
	    }
	 
	 @RequestMapping(value="/addnew", method = RequestMethod.GET)
	    public String addnewCustomer(Model model){
	        return "home";
	    }
}

