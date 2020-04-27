package com.cts.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.Customer;
import com.cts.crm.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	//addCustomer
	@PostMapping("addCustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerservice.addCustomer(customer);
		
	}
	//customer byId
	@GetMapping("customerById/{customerid}")
	public Optional<Customer> customerbyid(@PathVariable("customerid") int cid)
	{
		return customerservice.customerById(cid);
	}
	//view all customers
	@GetMapping("getAllCountomers")
	public List<Customer> getAllCustomers()
	{
		return customerservice.getAllCustomers();
	}

}
