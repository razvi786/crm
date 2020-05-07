package com.cts.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.config.DataServiceConfig;
import com.cts.crm.model.User;
import com.cts.crm.repo.UserJdbcRepo;
import com.cts.crm.repo.UserJpaRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	DataServiceConfig properties;
	
	@Autowired
	UserJpaRepo userJpaRepo;
	
	@Autowired
	UserJdbcRepo userJdbcRepo;

	@Override
	public User createUser(User user) {
		if(properties.getJpaEnable().equalsIgnoreCase("Y")) {
			return userJpaRepo.save(user);
		}else {
			return userJdbcRepo.save(user);
		}
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		if(properties.getJpaEnable().equalsIgnoreCase("Y")) {
			Optional<User> u=userJpaRepo.findByEmailAndPassword(email, password);
			User user=u.orElse(null);
			return user;
		}else {
			return userJdbcRepo.findByEmailAndPassword(email, password);
		}
		
	}

}
