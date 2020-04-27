package com.cts.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.dao.CustomerDao;
import com.cts.crm.model.Customer;

@Service
public class CustomerService {
	@Autowired 
	private CustomerDao customerdao;
	//add customer
	public Customer addCustomer(Customer customer) {
		
		return customerdao.save(customer);
	}
	public Optional<Customer> customerById(int cid) {
		
		return customerdao.findById(cid);
	}
	public List<Customer> getAllCustomers() {
		
		return customerdao.findAll();
	}

}
