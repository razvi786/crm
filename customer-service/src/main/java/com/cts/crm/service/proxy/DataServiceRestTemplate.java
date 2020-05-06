package com.cts.crm.service.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cts.crm.config.AuthorizationHeader;
import com.cts.crm.model.Customer;
import com.cts.crm.model.Subscription;
import com.cts.crm.model.User;

@Configuration
public class DataServiceRestTemplate {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AuthorizationHeader authHeader;
	
	//Customer Rest Controller Methods

	private static final String CREATE_CUSTOMER = "http://localhost:8000/customers";
	private static final String GET_CUSTOMER = "http://localhost:8000/customers/{id}";
	
	public ResponseEntity<Customer> createCustomer(Customer customer) {
		HttpEntity<Customer> request=new HttpEntity<>(customer,authHeader.getHeaders());
		return restTemplate.exchange(CREATE_CUSTOMER, HttpMethod.POST, request, Customer.class);
	}

	public ResponseEntity<Customer> searchCustomerById(int id) {
		HttpEntity<Customer> request=new HttpEntity<Customer>(authHeader.getHeaders());
		Map<String,Integer> uriVariables=new HashMap<>();
		uriVariables.put("id", id);
		return restTemplate.exchange(GET_CUSTOMER, HttpMethod.GET, request, Customer.class, uriVariables);
	}
	
	//User Rest Controller Methods
	
	private static final String CREATE_USER = "http://localhost:8000/users";
	private static final String GET_USER = "http://localhost:8000/users/{email}/{password}";
	
	public ResponseEntity<User> createUser(User user) {
		HttpEntity<User> request=new HttpEntity<User>(user, authHeader.getHeaders());
		return restTemplate.exchange(CREATE_USER, HttpMethod.POST, request, User.class);
	}

	public ResponseEntity<User> getUserByEmailAndPassword(String email, String password, HttpHeaders headers) {
		HttpEntity<User> request=new HttpEntity<>(headers);
		Map<String,String> uriVariables=new HashMap<>();
		uriVariables.put("email", email);
		uriVariables.put("password", password);
		return restTemplate.exchange(GET_USER, HttpMethod.GET, request, User.class, uriVariables);	
	}
	
	//Subscription Rest Controller Methods
	
	private static final String CREATE_SUBSCRIPTION = "http://localhost:8000/subscriptions";
	private static final String GET_SUBSCRIPTIONS = "http://localhost:8000/customers/{customerId}/subscriptions/active";
	
	public ResponseEntity<Subscription> createSubscription(Subscription subscription) {
		HttpEntity<Subscription> request=new HttpEntity<>(subscription, authHeader.getHeaders());
		return restTemplate.exchange(CREATE_SUBSCRIPTION, HttpMethod.POST, request, Subscription.class);
	}
	
	public ResponseEntity<List<Subscription>> viewActiveSubscriptions(int customerId) {
		HttpEntity<List<Subscription>> request=new HttpEntity<List<Subscription>>(authHeader.getHeaders());
		Map<String, Integer> uriVariables=new HashMap<>();
		uriVariables.put("customerId", customerId);
		ParameterizedTypeReference<List<Subscription>> subscriptions=new ParameterizedTypeReference<List<Subscription>>() {};
		return restTemplate.exchange(GET_SUBSCRIPTIONS, HttpMethod.GET, request, subscriptions , uriVariables);
	}

}
