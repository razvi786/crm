package com.cts.crm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.crm.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
