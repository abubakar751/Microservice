package com.userservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.userservice.entities.UserService;
import com.userservice.repository.UserRepository;
import com.userservice.services.UserServices;
@Service
public class ImplUserServices implements UserServices{
	@Autowired
private UserRepository repository;
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
		
		return repository.findById(userId).orElseThrow(() -> new ResourceAccessException("Given Id not found on server"));
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
