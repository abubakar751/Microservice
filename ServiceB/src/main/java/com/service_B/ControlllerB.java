package com.service_B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlllerB {
	
	@Autowired
	private BService service;
	@GetMapping("/")
	public String getData() {
		return "Hello From Service B   || "+service.getApiData();
	}
  
}
