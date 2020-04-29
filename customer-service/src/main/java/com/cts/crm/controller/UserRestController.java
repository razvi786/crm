package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.User;
import com.cts.crm.service.proxy.DataServiceProxy;

@RestController
public class UserRestController {
	
	@Autowired 
	DataServiceProxy userServiceProxy;
	
	@PostMapping("create-user")
	public User createUser(@RequestBody User user) {
		return userServiceProxy.createUser(user);
	}
	
	@GetMapping("get-user/{email}/{password}")
	public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return userServiceProxy.getUserByEmailAndPassword(email, password);
	}

}
