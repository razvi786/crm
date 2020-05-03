package com.cts.crm.service.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.crm.model.Customer;
import com.cts.crm.model.Subscription;
import com.cts.crm.model.User;

@FeignClient(name="data-service")
@RibbonClient(name="data-service")
public interface DataServiceProxy {
	
	@PostMapping("create-user")
	public ResponseEntity<User> createUser(@RequestBody User user);
	
	@GetMapping("get-user/{email}/{password}")
	public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password);
	
	@PostMapping("create-customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer);
	
	@GetMapping("search-customer/{id}")
	public ResponseEntity<Customer> searchCustomerById(@PathVariable int id);
	
	@GetMapping("view-active-subscriptions/{customerId}")
	public ResponseEntity<List<Subscription>> viewActiveSubscriptions(@PathVariable int customerId);
	
	@PostMapping("create-subscription")
	public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription);
 
}
