package com.example.caching.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class CacheController {

	@Autowired
	DefaultCustomerService defaultCustomerService;

	@GetMapping("caffeine/{segmentID}")
	ResponseEntity<Customer> test(@PathVariable("segmentID") String segmentID) throws Exception {
		
		Customer cd = defaultCustomerService.getCustomer(segmentID);
		return new ResponseEntity<>(cd, HttpStatus.OK);

	}

}
