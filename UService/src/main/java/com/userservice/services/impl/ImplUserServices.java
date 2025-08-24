package com.userservice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;
import com.userservice.entities.Rating;
import com.userservice.entities.UserService;
import com.userservice.repository.UserRepository;
import com.userservice.services.UserServices;
@Service
public class ImplUserServices implements UserServices{
	@Autowired
private UserRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public UserService saveUser(UserService service) {
		return repository.save(service);
	}

	@Override
	public List<UserService> getAllUser() {
		
		return repository.findAll();
	}

	@Override
	public UserService getUser(String userId) {
		
		UserService userService=repository.findById(userId).orElseThrow(() -> new ResourceAccessException("Given Id not found on server"));
	ArrayList<Rating> forObject = restTemplate.getForObject("http://localhost:1003/rating/userid/"+userService.getUserId(), ArrayList.class);
	userService.setRatings(forObject);
	return userService;
	}

	@Override
	public void deleteUser(String userId) {
		repository.findById(userId).get();
		
	}

	@Override
	public UserService updateUser(UserService service, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
