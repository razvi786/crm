package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.exception.UserNotFoundException;
import com.cts.crm.model.User;
import com.cts.crm.service.rest.DataServiceRestTemplate;

@RestController
public class UserRestController {
	
	@Autowired 
	DataServiceRestTemplate dataServiceRestTemplate;
	
	@PostMapping("users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = dataServiceRestTemplate.createUser(user).getBody();
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
	}
	
	@GetMapping("users/{email}/{password}")
	public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		User user = dataServiceRestTemplate.getUserByEmailAndPassword(email, password).getBody();
		if(user==null)
			throw new UserNotFoundException("user with Email:"+email+" and Password:"+password+" not found");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
