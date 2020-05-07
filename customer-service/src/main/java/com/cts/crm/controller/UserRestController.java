package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.exception.UserNotFoundException;
import com.cts.crm.model.User;
import com.cts.crm.service.rest.DataServiceRestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserRestController {
	
	@Autowired 
	DataServiceRestTemplate dataServiceRestTemplate;
	
	@PostMapping("users")
	@HystrixCommand(fallbackMethod = "postFallbackUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = dataServiceRestTemplate.createUser(user).getBody();
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
	}
	
	@GetMapping("users/{email}/{password}")
	@HystrixCommand(fallbackMethod = "getFallbackUser")
	public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		User user = dataServiceRestTemplate.getUserByEmailAndPassword(email, password).getBody();
		if(user==null)
			throw new UserNotFoundException("user with Email:"+email+" and Password:"+password+" not found");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	//	Hystrix Fallback Methods	
	public  ResponseEntity<User> postFallbackUser(@RequestBody User user){
		User response = new User(0, "Server is currently down", null, null, null);
		return new ResponseEntity<User>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public  ResponseEntity<User> getFallbackUser(@PathVariable String email, @PathVariable String password){
		User response = new User(0, "Server is currently down", null, null, null);
		return new ResponseEntity<User>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
