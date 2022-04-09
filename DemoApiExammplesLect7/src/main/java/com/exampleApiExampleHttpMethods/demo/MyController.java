package com.exampleApiExampleHttpMethods.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	//Api - Method, Request,Response,endpoint
	
	//Http method are 
	//GET - it is used to retrive some response from backend - Safe - GIVE SAME RESPONSE ALWAYS
	//POST - iS USED to store some data to the backend - unsafe - can be manipulated 
	//PUT - method is used to update - unsafe
	//DELETE - used to delete some data from the backend - unsafe 
	// PATCH, HEAD, OPTIONS
	
	
	//@RequestMapping(method=RequestMethod.GET) --- old way in lower version of spring boot it was introduced
	//@GetMapping("/getExamDetails") // was intrduced in higher version 
	public String getMyExamDetails(@RequestParam("grt") String greet)
	{
		return "USPC exam deatils: Exam date is 12th May: " + greet;
		
	}
	//http://localhost:8080/getExamDetails?grt=GoodMorning
	//http://localhost:8080/getExamDetails?greeting=GoodMorning
	
	//Spring web ------@RequestParam
	//Jax-rs ---------- @QueryParam
	
	
	//Http status codes
	// 200 - request was successfull
	// 404 - endpoint  was not found 
	// 500 - Internal server error
	// 401 - Unauthorize  -- invalid user of app
	// 403 - forbidden ----- u r a valid user for the site but u dont have access to perform some action on given few urls
	// 405 - method not allowed
	
	
	
	//@GetMapping("/getExamDetails/{var}")
	public String getMyExamDetails2(@PathVariable("var") String val)
	{
		return "USPC exam deatils: Exam date is 12th May: " + val;
		
	}
	
	/////Spring web and jax rs 
	//    GetMapping and GET
	// RequestParam and Query Param
	// PathVariable and Path Param
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
