package com.cts.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.dao.UserDao;
import com.cts.crm.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;

	public User addUser(User user) {
		
		return userdao.save(user);
	}

	public Optional<User> getUserId(int uid) {
		
		return userdao.findById(uid);
	}
 
}
