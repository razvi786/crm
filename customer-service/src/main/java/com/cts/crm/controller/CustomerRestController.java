package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.Customer;
//import com.cts.crm.service.proxy.DataServiceProxy;
import com.cts.crm.service.proxy.DataServiceRestTemplate;

@RestController
public class CustomerRestController {
	
	/*@Autowired
	DataServiceProxy dataServiceProxy;
	
	@PostMapping("customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return dataServiceProxy.createCustomer(customer);
	}
	
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> searchCustomerById(@PathVariable int id) {
		return dataServiceProxy.searchCustomerById(id);
	}*/
	
	@Autowired
	DataServiceRestTemplate dataServiceProxy;
	
	@PostMapping("customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return dataServiceProxy.createCustomer(customer);
	}
	
	@GetMapping("customers/{id}")
	public Customer searchCustomerById(@PathVariable int id) {
		return dataServiceProxy.searchCustomerById(id);
	}

}
