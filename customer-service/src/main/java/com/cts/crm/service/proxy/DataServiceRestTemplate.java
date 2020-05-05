package com.cts.crm.service.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.cts.crm.model.Customer;
import com.cts.crm.model.Subscription;
import com.cts.crm.model.User;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;
@Configuration
public class DataServiceRestTemplate {
	@Autowired
	  RestTemplate restTemplate;
	private static final String CREATE_USERS = "http://localhost:8000/users";
    private static final String GET_USERS = "http://localhost:8000/users/{email}/{password}";
    private static final String CREATE_CUSTOMERS = "http://localhost:8000/customers";
    private static final String GET_CUSTOMER = "http://localhost:8000/customers/{id}";
    private static final String GET_SUBSCRIPTIONS = "http://localhost:8000/customers/{customerId}/subscriptions/active";
    private static final String CREATE_SUBSCRIPTION = "http://localhost:8000/subscriptions";
    
	public Customer createCustomer(Customer customer) {
		Customer result = restTemplate.postForObject(CREATE_CUSTOMERS,customer,Customer.class);
		return result;
		   }
	public Customer searchCustomerById(int id) {
		
		return restTemplate.getForObject(GET_CUSTOMER,Customer.class,id);
	}

	public Subscription viewActiveSubscriptions(int customerId) {
		Subscription result=restTemplate.getForObject(GET_SUBSCRIPTIONS,Subscription.class,customerId);
		return result;
	}
	public Subscription createSubscription(Subscription subscription) {
		Subscription result=restTemplate.postForObject(CREATE_SUBSCRIPTION,subscription,Subscription.class);
		return result;
	}
	public User createUser(User user) {
		User result = restTemplate.postForObject(CREATE_USERS,user,User.class);
		return result;
	}
	public User getUserByEmailAndPassword(String email, String password) {
		User result = restTemplate.getForObject(GET_USERS,User.class,email,password);
		return result;
	}
	
}
