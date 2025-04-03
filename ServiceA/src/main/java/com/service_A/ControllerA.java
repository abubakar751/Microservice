package com.service_A;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerA {
	@GetMapping("/")
	public String getMassage() {
		return "Hello World from Service A ";
	}

}
