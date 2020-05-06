package com.cts.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationHeader {
	
	@Autowired
	SchedulerServiceConfig properties;
	
	private HttpHeaders headers = new HttpHeaders();
	
	public AuthorizationHeader() {
	}
	
	public HttpHeaders getHeaders() {
		headers.add("Authorization", properties.getAuthorizationHeader());
		return headers;
	}

}
