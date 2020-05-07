package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.Customer;
import com.cts.crm.service.rest.DataServiceRestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CustomerRestController {
	
	@Autowired
	DataServiceRestTemplate dataServiceRestTemplate;
	
	@PostMapping("customers")
	@HystrixCommand(fallbackMethod ="postFallbackCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return dataServiceRestTemplate.createCustomer(customer);
	}
	
	public  ResponseEntity<Customer> postFallbackCustomer(@RequestBody Customer customer){
		Customer response=new Customer(0,"Server is Currently Down","","","","");
		return new ResponseEntity<Customer>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("customers/{id}")
	@HystrixCommand(fallbackMethod ="getFallbackCustomer")
	public ResponseEntity<Customer> searchCustomerById(@PathVariable Integer id) {
		return dataServiceRestTemplate.searchCustomerById(id);
	}
	
	public  ResponseEntity<Customer> getFallbackCustomer(@PathVariable Integer id){
		Customer response=new Customer(0,"Server is Currently Down","","","","");
		return new ResponseEntity<Customer>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
