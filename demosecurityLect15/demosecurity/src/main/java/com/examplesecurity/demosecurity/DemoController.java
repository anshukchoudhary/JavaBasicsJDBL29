package com.examplesecurity.demosecurity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/demoGreet")
	public String greet() {

		/*
		 * Authentication auth =
		 * SecurityContextHolder.getContext().getAuthentication();
		 * 
		 * User user = (User) auth.getPrincipal();
		 * 
		 * user.getPassword(); user.getUsername();
		 */

		return "Hi User";
	}

	@GetMapping("/developer")
	public String greetDeveloper() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return "Hi developer User" + user.getUsername() + "!!!!";
	}
	
	
/*	@PostMapping("/developer")
	public String greetDeveloper2(@RequestParam("name") String name) {
		return "Hi developer User" + name + "!!!!";
	}*/

	@GetMapping("/devops")
	public String greetDevops(@RequestParam("name") String name) {

		return "Hi devops User" + name + "!!!!";
	}

}
