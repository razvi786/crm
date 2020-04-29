package com.cts.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.model.User;
import com.cts.crm.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		Optional<User> u=userRepo.findByEmailAndPassword(email, password);
		User user=u.orElse(null);
		return user;
	}

}
