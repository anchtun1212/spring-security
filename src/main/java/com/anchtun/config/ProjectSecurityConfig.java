package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	// override and modifying the code as per our custom requirement
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
		.antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
		.antMatchers("/welcome", "/contact", "/notices").permitAll()
		.and().formLogin()
		.and().httpBasic();

		return http.build();
	}
}
