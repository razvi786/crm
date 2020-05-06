package com.cts.crm.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Configuration
@EnableAsync
@Data
public class SchedulerServiceConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Value("${spring.security.username}")
	private String username;
	
	@Value("${spring.security.password}")
	private String password;
	
	@Value("#{'${spring.security.role}'.split(',')}")
	private List<String> roles;
	
	@Value("${spring.headers.authorization}")
	private String authorizationHeader;

}
