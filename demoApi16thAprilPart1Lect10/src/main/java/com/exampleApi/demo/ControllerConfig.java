package com.exampleApi.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration//it is kind of used for component scanning to make this class visible to spring //to name config - @Configuration(value="xyz") 
public class ControllerConfig {
	//HW create a singleton and prototype class 
	@Bean                                 //@Bean(name="myTemplate3") //this bean is used to define object or class which are part of source code or lib
	@Scope("prototype")
	public RestTemplate getTemplate(){
		return new RestTemplate();
	}
	
	
	/*@Bean                                 //@Bean(name="myTemplate3") //this bean is used to define object or class which are part of source code or lib
	//@Scope("prototype")
	public RestTemplate getTemplate2(){
		return new RestTemplate();
	}*/
	
	
	
	
	

	//beans are stored as key value pair in the IOC container
	//key -- is the bean name, value is that object reference
	//by deafult the bean name will be method name in camel case
	
	
	
}
