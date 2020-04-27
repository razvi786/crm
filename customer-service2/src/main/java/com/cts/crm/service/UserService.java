package com.cts.crm.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.crm.model.User;

@FeignClient(name="data-service")
@RibbonClient(name="data-service")
public interface UserService {
	
	@PostMapping("create-user")
	public User createUser(User user);
	
	@GetMapping("get-user/{username}/{password}")
	public User getUserByUsernameAndPassword(String username,String password);
 
}
