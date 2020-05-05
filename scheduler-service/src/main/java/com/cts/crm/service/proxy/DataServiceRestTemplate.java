/*package com.cts.crm.service.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cts.crm.model.Subscription;

@Configuration
public class DataServiceRestTemplate {
	@Autowired RestTemplate restTemplate;
	//private static final String GET_ALL = "http://localhost:8000/users";
    //private static final String INACTIVE = "http://localhost:8000/users/{email}/{password}";

	public Object getAllSubscriptions() {
		
		return restTemplate.exchange(Subscription,List<>)
	}

	public void batchInactiveSubscriptions(List<Subscription> todaySubscriptions) {
		
		
	}

}*/
