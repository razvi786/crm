package com.cts.crm.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.crm.model.User;

@FeignClient(name="data-service")
@RibbonClient(name="data-service")
public interface UserServiceProxy {
	
	@PostMapping("create-user")
	public User createUser(@RequestBody User user);
	
	@GetMapping("get-user/{email}/{password}")
	public User getUserByEmailAndPassword(@PathVariable String email,@PathVariable String password);
 
}
