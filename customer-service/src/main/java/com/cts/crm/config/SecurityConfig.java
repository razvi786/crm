package com.cts.crm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
      	.authorizeRequests()
      	.anyRequest().authenticated()
        .and()
        .httpBasic();
    }
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//			.usersByUsernameQuery("select email,password from user where email=?")
//			.authoritiesByUsernameQuery("select email,user_type from user where email=?")
//			.dataSource(dataSource)
//			.passwordEncoder(new PasswordEncoder() {
//				@Override
//				public boolean matches(CharSequence rawPassword, String encodedPassword) {
//					return rawPassword.equals(encodedPassword);
//				}
//				@Override
//				public String encode(CharSequence rawPassword) {
//					return rawPassword.toString();
//				}
//			});
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("username")
		.password("{noop}password")
		.roles("ADMIN");
	}
	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
	
	
	
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource corsSource=new UrlBasedCorsConfigurationSource();
//		CorsConfiguration corsConfig=new CorsConfiguration();
//		corsConfig.setAllowCredentials(true);
//		corsConfig.addAllowedOrigin("*");
//		corsConfig.addAllowedHeader("*");
//		corsConfig.addAllowedMethod("OPTIONS");
////		corsConfig.addAllowedMethod("GET");
//		corsConfig.addAllowedMethod(HttpMethod.GET);
//		corsConfig.addAllowedMethod("POST");
//		corsConfig.addAllowedMethod("PUT");
//		corsConfig.addAllowedMethod("DELETE");
//		corsSource.registerCorsConfiguration("/**", corsConfig);
//		return new CorsFilter(corsSource);
//	}
	
}