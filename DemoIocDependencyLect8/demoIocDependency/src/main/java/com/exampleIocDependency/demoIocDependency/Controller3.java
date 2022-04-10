package com.exampleIocDependency.demoIocDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller3 {
	
	
	@Autowired
	IocDependencyExample2Controller obj;
	
	// so both are same right ?
	//cool
	//wait 1 min
	
	
	@GetMapping("/iocExample3")
	public String generateRandomId(){
		
		//IocDependencyExample2Controller obj = new IocDependencyExample2Controller();
		obj.getDetails();
		
		
		//System.out.println("IocDependencyExampleController111 iocExample3" + this);
		System.out.println("IocDependencyExample2Controller22222  iocExample3" + obj);
		//return UUID.randomUUID().toString();
		
		return obj.getDetails();
	}
	
	
	@GetMapping("/iocExample4")
	public String generateRandomId4(){
		
		//IocDependencyExample2Controller obj = new IocDependencyExample2Controller();
		obj.getDetails();
		
		
		System.out.println("IocDependencyExampleController111 iocExample4" + this);
		System.out.println("IocDependencyExample2Controller22222  iocExample4" + obj);
		//return UUID.randomUUID().toString();
		
		return obj.getDetails();
	}
	

	
	
	
}
