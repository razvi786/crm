package com.cts.crm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.User;
import com.cts.crm.service.UserService;

@RestController
public class UserController {
	@Autowired 
	private UserService userservice;
	
	@PostMapping("addUser")
	public User saveUser(@RequestBody User user) {
		return userservice.addUser(user);
	}
	
	@GetMapping("getUserById/{userId}")
	public Optional<User> getUserById(@PathVariable("userId") int uid)
	{
		return userservice.getUserId(uid);
	}

}
