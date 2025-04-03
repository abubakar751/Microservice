package com.service_B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BService {
	@Autowired
	  private RestTemplate template;
	public String getApiData() {
		String url="http://localhost:8081";
		 return template.getForObject(url,String.class);
	}
		
		

}
