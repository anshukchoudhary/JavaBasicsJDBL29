package com.exampleApi.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@ResponseBody
public class Controller2 {
	
	@GetMapping("/message2/m2")
	@ResponseBody
	public String getMessage(@RequestParam("msg") String msg) {
		return "Hello Anjali " + msg;
	}
	
	
	
	
	
	
	
	
	
	
	
/*	@Override
	public String getDisplayDetails(){
		return null;
		
	}*/

}
