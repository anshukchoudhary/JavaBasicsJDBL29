package com.exampleApi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetrieveImageController {
	
	@Autowired // filed injection
	//@Qualifier("getTemplate")
	RestTemplate rt;
	
	
/*	ControllerConfig controllerConfig;
	//constructor way 
	public RetrieveImageController(ControllerConfig controllerConfig){
		
		this.controllerConfig = controllerConfig;
	}*/
	
	

	
	
	
    private static Logger logger = LoggerFactory.getLogger(RetrieveImageController.class);

	// design a api to get the image as response

	// input to api input idrequired = true // length / breadth (200x200)
	// output - image to show

	// consumes ----- tells us the kinds of data that will be consumed in the
	// request
	// produces ---- tell us the type of data produced as reponse
	
	//http://localhost:8080/image?id=1&l=200&b=300

	@GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage(@RequestParam("id") int id,
			@RequestParam(value = "l", required = false, defaultValue = "200") int l,
			@RequestParam(value = "b", required = false, defaultValue = "200") int b) {
		
	

		String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b;

		//RestTemplate rt = controllerConfig.getTemplate();
		logger.info("value of restTemplate RetrieveImageController --->   " + rt);

		byte[] response = rt.getForObject(url, byte[].class);

		return response;

	}
	
	@GetMapping(value = "/image2", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage2(@RequestParam("id") int id,
			@RequestParam(value = "l", required = false, defaultValue = "200") int l,
			@RequestParam(value = "b", required = false, defaultValue = "200") int b) {

		String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b;



		//byte[] response = rt.getForObject(url, byte[].class);

		return null;

	}
	
	
	
	
	
	

}
