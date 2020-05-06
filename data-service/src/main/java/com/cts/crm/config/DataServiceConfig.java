package com.cts.crm.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Data
public class DataServiceConfig {
	
	//Properties
	@Value("${subscription.update.query}")
	String subscriptionUpdateQuery;
	
	@Value("${spring.security.username}")
	private String username;
	
	@Value("${spring.security.password}")
	private String password;
	
	@Value("#{'${spring.security.role}'.split(',')}")
	private List<String> roles;
	
	//Swagger2 Configurations
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cts.crm"))
				.build();
	}

}
