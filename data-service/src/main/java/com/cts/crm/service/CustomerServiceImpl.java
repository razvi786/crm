package com.cts.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.model.Customer;
import com.cts.crm.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer searchCustomerById(int id) {
		Optional<Customer> c=customerRepo.findById(id);
		Customer customer=c.orElse(null);
		return customer;
	}

}
