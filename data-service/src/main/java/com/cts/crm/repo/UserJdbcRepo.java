package com.cts.crm.repo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cts.crm.model.User;

@Repository
public class UserJdbcRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	public User findByEmailAndPassword(String email,String password){
		String query="SELECT * FROM user WHERE email=? AND password=?";
		return jdbcTemplate.queryForObject(query, new Object[] {email,password}, new BeanPropertyRowMapper<>(User.class) );
	}
	
	public User save(User user) {
		String query="INSERT INTO user VALUES (?,?,?,?,?) RETURN_GENERATED_KEYS";
		KeyHolder keyHolder = new GeneratedKeyHolder();
//		PreparedStatementCreator psc = new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps=con.prepareStatement(query);
//				ps.setInt(1, user.getId());
//				ps.setString(2, user.getEmail());
//				ps.setString(3, user.getName());
//				ps.setString(4, user.getPassword());
//				ps.setString(5, user.getUserType());
//				return ps;
//			}
//		};
		PreparedStatementCreator psc=(con)->{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getName());
			ps.setString(4, user.getPassword());
			ps.setString(5, "ROLE_USER");
			return ps;
		};
		jdbcTemplate.update(psc, keyHolder);
		String query2="SELECT * FROM user WHERE id=?";
		System.out.println(keyHolder.getKey());
		return jdbcTemplate.queryForObject(query2, new Object[] {keyHolder.getKey()}, new BeanPropertyRowMapper<>(User.class) );
	}

}
