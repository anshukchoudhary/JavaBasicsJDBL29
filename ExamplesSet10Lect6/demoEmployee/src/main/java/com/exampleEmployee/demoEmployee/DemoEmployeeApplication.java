package com.exampleEmployee.demoEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoEmployeeApplication {

	//precedence order for server is - tomcat ----- jetty ------- undertow
	//app.properties - u can define custom property which are not inbuilt present in spring , u can override existing property
	public static void main(String[] args) {
		SpringApplication.run(DemoEmployeeApplication.class, args);
		System.out.println("Hi Good Evening....");
	}

}
