package com.cts.crm.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@RefreshScope
public class ZuulConfig {
	
	@Value("${spring.gateway.username}")
	private String username;
	
	@Value("${spring.gateway.password}")
	private String password;
	
	@Value("${spring.gateway.role}")
	private List<String> roles;

}
