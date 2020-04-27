package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.User;
import com.cts.crm.service.UserServiceProxy;

@RestController
public class UserRestController {
	
	@Autowired 
	private UserServiceProxy userService;
	
	@PostMapping("create-user")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("get-user/{email}/{password}")
	public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return userService.getUserByEmailAndPassword(email, password);
	}

}
