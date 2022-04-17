package com.exampleApi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller3 {
	
	@Value("${jdbl.lecture.number}")
	int age;
	
	@Autowired
	//@Qualifier("getTemplate2")
	RestTemplate rt;
	
	   private static Logger logger = LoggerFactory.getLogger(Controller3.class);
	//http://localhost:8080/image3?id=1&l=200&b=300
	@GetMapping(value = "/image3", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage2(@RequestParam("id") int id,
			@RequestParam(value = "l", required = false, defaultValue = "200") int l,
			@RequestParam(value = "b", required = false, defaultValue = "200") int b) {

		
		logger.info("value of restTemplate Controller3--->   " + rt);
		
		String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b;

		System.out.println("ageageageageageageage: " + age);

		byte[] response = rt.getForObject(url, byte[].class);

		return response;

	}
	
	//value of restTemplate RetrieveImageController --->   org.springframework.web.client.RestTemplate@3d103154

//value of restTemplate Controller3--->                org.springframework.web.client.RestTemplate@3d103154 
	

}
