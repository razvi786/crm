package com.cts.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.crm.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{

}
