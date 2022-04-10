package com.exampleIocDependency.demoIocDependency;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class IocDependencyExample2Controller {

	public String getDetails() {
		return "name is tomcar ----- age is 30";
	}

}
