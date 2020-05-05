package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.User;
//import com.cts.crm.service.proxy.DataServiceProxy;
import com.cts.crm.service.proxy.DataServiceRestTemplate;

@RestController
public class UserRestController {
	
	/*@Autowired 
	DataServiceProxy userServiceProxy;
	
	@PostMapping("users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return userServiceProxy.createUser(user);
	}
	
	@GetMapping("users/{email}/{password}")
	public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return userServiceProxy.getUserByEmailAndPassword(email, password);
	}*/
	@Autowired 
	DataServiceRestTemplate userServiceProxy;
	
	@PostMapping("users")
	public User createUser(@RequestBody User user) {
		return userServiceProxy.createUser(user);
	}
	
	@GetMapping("users/{email}/{password}")
	public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return userServiceProxy.getUserByEmailAndPassword(email, password);
	}

}
