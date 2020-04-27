package com.cts.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.crm.model.User;

public interface UserDao extends JpaRepository<User,Integer>{

}
