package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.cts.crm.exception.CustomerNotFoundException;
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
		Customer createdCustomer = dataServiceRestTemplate.createCustomer(customer).getBody();
		return new ResponseEntity<Customer>(createdCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("customers/{id}")
	@HystrixCommand(fallbackMethod ="getFallbackCustomer")
	public ResponseEntity<Customer> searchCustomerById(@PathVariable Integer id) {
		Customer customer = dataServiceRestTemplate.searchCustomerById(id).getBody();
		if(customer==null)
			throw new CustomerNotFoundException("id: "+id+" not found");
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	//	Hystrix Fallback Methods	
	public  ResponseEntity<Customer> postFallbackCustomer(@RequestBody Customer customer){
		throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Customer could not be created. Please try again later");
	}
	public  ResponseEntity<Customer> getFallbackCustomer(@PathVariable Integer id){
		throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Customer "+id+" Not Found. Please try again later");
	}
	

}
