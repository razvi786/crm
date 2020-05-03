package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.Customer;
import com.cts.crm.service.proxy.DataServiceProxy;

@RestController
public class CustomerRestController {
	
	@Autowired
	DataServiceProxy dataServiceProxy;
	
	@PostMapping("create-customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return dataServiceProxy.createCustomer(customer);
	}
	
	@GetMapping("search-customer/{id}")
	public ResponseEntity<Customer> searchCustomerById(@PathVariable int id) {
		return dataServiceProxy.searchCustomerById(id);
	}

}
