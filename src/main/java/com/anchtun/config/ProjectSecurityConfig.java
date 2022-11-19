package com.anchtun.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfig {

	// override and modifying the code as per our custom requirement
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.securityContext().requireExplicitSave(false).and().cors()
				.configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration config = new CorsConfiguration();
						config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
						config.setAllowedMethods(Collections.singletonList("*"));
						config.setAllowCredentials(true);
						config.setAllowedHeaders(Collections.singletonList("*"));
						config.setMaxAge(3600L);// 1 hour
						return config;
					}
				})
		//By default, spring security framework is going to stop all POST/PUT requests 
		//that are going to update the data inside the database or inside the back end.
		//So all such requests will be blocked by default just to make sure to avoid the CSRF attack.
		//so we will disable CSRF
		// not recommended in PROD just for POC purpose 
		//and().csrf().disable()
		.and().csrf().ignoringAntMatchers("/contact", "/register")// No need to protect csrf for those public links, anyone can register and send message
		// So with this, what I'm telling to spring security framework: please generate an CSRF Token and
		// send that token as a cookie to my client applications.
		// So whenever we define withHttpOnly as false, my client applications also they can read the cookie
        // using JavaScript code. Otherwise only my backend server can read the cookies but not the UI applications.
		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and().authorizeHttpRequests()
		//.antMatchers("/myAccount").hasAnyAuthority("SUPERADMIN", "ADMINISTRATOR")// Authorities not exists so if you open developer console you will see 403 response error 
		//.antMatchers("/myCards").hasAnyAuthority("SUPERUSER")// Authority not exists so if you open developer console you will see 403 response error
		//.antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards", "/user").authenticated()
		.antMatchers("/myAccount").hasRole("USER")
		.antMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
		.antMatchers("/myLoans").hasRole("USER")
		.antMatchers("/myCards").hasRole("USER")
		.antMatchers("/user").authenticated()
		.antMatchers("/welcome", "/contact", "/notices", "/register").permitAll()
		.and().formLogin()
		.and().httpBasic();
		return http.build();
	}
	
	// CONFIGURE USERS
	// approach 1
	// not recommended: could be used for POC
	// so here I ask spring to get the data from the memory because the bean is InMemoryUserDetailsManager
	// not for example: JdbcUserDetailsManager or LdapUserDetailsManager
	/*@Bean
	InMemoryUserDetailsManager userDetailsService() {
	    // deprecated: mean do not use in PROD
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("12345678")
				.authorities("admin")
				.build();
		// deprecated: mean do not use in PROD
		UserDetails simpleUser = User.withDefaultPasswordEncoder()
				.username("user")
				.password("12345678")
				.authorities("user")
				.build();
		return new InMemoryUserDetailsManager(admin, simpleUser);
	}*/
	
	// CONFIGURE USERS
	// approach 2
	// not recommended: could be used for POC
	/*@Bean
	InMemoryUserDetailsManager userDetailsService() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		UserDetails admin = User.withUsername("admin").password("password").authorities("admin").build();
		UserDetails user = User.withUsername("user").password("password").authorities("user").build();
		inMemoryUserDetailsManager.createUser(admin);
		inMemoryUserDetailsManager.createUser(user);
		return inMemoryUserDetailsManager;
	}*/
	
	// create new bean JdbcUserDetailsManager
	// DataSource: spring will check the application.properties directly
	// will check the default tables expected by spring: users and authorities
	// but because we need to make our CUSTOM tables for authentication we will not use JdbcUserDetailsManager
	/*@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}*/
	
	// we need always to talk with spring how our password are stored
	/*@Bean
	PasswordEncoder passwordEncoder() {
		// deprecated: mean do not use in PROD
		return NoOpPasswordEncoder.getInstance();
	}*/
	
	@Bean
	PasswordEncoder passwordEncoder() {
		// recommended hash algorith for PROD
		return new BCryptPasswordEncoder();
	}
	
}
