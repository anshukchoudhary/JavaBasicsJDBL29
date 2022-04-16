package com.exampleApi.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetrieveImageController {

	// design a api to get the image as response

	// input to api input idrequired = true // length / breadth (200x200)
	// output - image to show

	// consumes ----- tells us the kinds of data that will be consumed in the
	// request
	// produces ---- tell us the type of data produced as reponse

	@GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage(@RequestParam("id") int id,
			@RequestParam(value = "l", required = false, defaultValue = "200") int l,
			@RequestParam(value = "b", required = false, defaultValue = "200") int b) {

		String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b;

		RestTemplate rt = new RestTemplate();

		byte[] response = rt.getForObject(url, byte[].class);

		return response;

	}

}
