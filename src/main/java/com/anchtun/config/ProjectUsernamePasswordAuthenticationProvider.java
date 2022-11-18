package com.anchtun.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.anchtun.model.Customer;
import com.anchtun.service.CustomerService;

import lombok.AllArgsConstructor;

// our custom authentication logic
@AllArgsConstructor
@Component
public class ProjectUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
	
	private final CustomerService customerService;
	private final PasswordEncoder passwordEncoder;

	// Inside this authenticate method, it is our responsibility to define all the authentication logic right from loading the user details
	// from that storage system, comparing the passwords. And post that, we should create a successful authentication object
	// with an information whether the authentication is successful or not.
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		Customer customer = customerService.findByEmail(username);
		if (Objects.nonNull(customer)) {
			if (passwordEncoder.matches(password, customer.getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(customer.getRole().name()));
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			} else {
				throw new BadCredentialsException("Wrong password");
			}
		} else {
			throw new BadCredentialsException("User details not exists");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// if you want to support username, password authentication 
		// copy this from AbstractUserDetailsAuthenticationProvider
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
