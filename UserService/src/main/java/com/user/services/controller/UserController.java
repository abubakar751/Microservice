package com.user.services.controller;

import com.user.services.entity.User;
import com.user.services.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") 
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveData(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);  // Return 201 status
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = userService.getDataById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);  // Return 200 status
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllData();
        return new ResponseEntity<>(users, HttpStatus.OK);  // Return 200 status
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        User updatedUser = userService.updateData(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);  // Return 200 status
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteData(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return 204 status (no content)
    }
}
