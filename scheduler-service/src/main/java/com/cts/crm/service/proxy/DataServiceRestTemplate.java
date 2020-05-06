package com.cts.crm.service.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cts.crm.config.AuthorizationHeader;
import com.cts.crm.model.Subscription;

@Configuration
public class DataServiceRestTemplate {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AuthorizationHeader authHeader;
	
	//Subscription Rest Controller Methods
	
	private static final String GET_ALL_SUBSCRIPTIONS = "http://localhost:8000/subscriptions";
    private static final String INACTIVE_SUBSCRIPTIONS = "http://localhost:8000/subscriptions/batch-inactive";

	public ResponseEntity<List<Subscription>> getAllSubscriptions() {
		System.out.println(authHeader.getHeaders());
		HttpEntity<List<Subscription>> request=new HttpEntity<List<Subscription>>(authHeader.getHeaders());
		ParameterizedTypeReference<List<Subscription>> subscriptions=new ParameterizedTypeReference<List<Subscription>>() {
		};
		return restTemplate.exchange(GET_ALL_SUBSCRIPTIONS, HttpMethod.GET, request, subscriptions);
	}

	public ResponseEntity<Void> batchInactiveSubscriptions(List<Subscription> todaySubscriptions) {
		HttpEntity<List<Subscription>> request=new HttpEntity<List<Subscription>>(todaySubscriptions,authHeader.getHeaders());
		return restTemplate.exchange(INACTIVE_SUBSCRIPTIONS, HttpMethod.POST, request, Void.class);
	}

}
