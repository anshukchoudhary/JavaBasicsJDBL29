package com.exampleApi.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	// i will make an api
	

	
	@GetMapping("/message/m1")
	public String getMessage(@RequestParam("msg") String msg) {
		return "Hello Ryan " + msg;
	}
	
	
	////Controller ------ was not have response body
	// rest controller ----- is having controller + responsebody
	
	//java-----json -------------- @ResponseBody
	//json(CLIENT)----java --------------  @RequestBody
	
	
	//Rtention policy
	//SOURCE ------- will be discarded by the compiler while generating byte code
	// CLASS ------- recorded in the bytecode but not needed at the runtime 
	// RUNITME ----- will be there at runtime and will not be discarded by any one 
	
	
	
	

	

}
