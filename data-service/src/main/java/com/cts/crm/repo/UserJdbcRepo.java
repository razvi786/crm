package com.cts.crm.repo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.crm.model.User;

@Repository
public class UserJdbcRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User findByEmailAndPassword(String email,String password){
		String query="SELECT * FROM user WHERE email=? AND password=?";
		return jdbcTemplate.queryForObject(query, new Object[] {email,password}, new BeanPropertyRowMapper<>(User.class) );
	}

}
