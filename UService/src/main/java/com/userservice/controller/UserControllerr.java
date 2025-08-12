package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entities.UserService;
import com.userservice.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserControllerr {
	@Autowired
	private UserServices userServices;
	@PostMapping("/post")
	public ResponseEntity<UserService> createUser(@RequestBody UserService service){
		
		 UserService saveUser = userServices.saveUser(service);
		 return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	@GetMapping("/user/{userId}")
public ResponseEntity<UserService>   getuser(@PathVariable String userId) {
	 com.userservice.entities.UserService user = userServices.getUser(userId);
	 
	 return ResponseEntity.ok(user);
}
	@GetMapping("/getAll")
	public ResponseEntity<List<UserService>> getAll(){
		List<UserService> allUser = userServices.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
