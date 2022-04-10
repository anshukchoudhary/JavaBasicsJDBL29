package com.exampleIocDependency.demoIocDependency;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IocDependencyExampleController {
	
	@Autowired
	IocDependencyExample2Controller obj;
	
	@GetMapping("/iocExample")
	public String generateRandomId(){
		
		
		obj.getDetails();
		
		
		//System.out.println("IocDependencyExampleController111" + this);
		System.out.println("IocDependencyExample2Controller22222" + obj);
		//return UUID.randomUUID().toString();
		
		return obj.getDetails();
	}
	

}
