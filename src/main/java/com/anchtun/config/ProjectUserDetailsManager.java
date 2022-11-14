package com.anchtun.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anchtun.model.Customer;
import com.anchtun.repository.CustomerRepository;

import lombok.AllArgsConstructor;

/**
 * 
 * @author anchtun1212
 * custom user fetching logic
 */
//When we want to load the user details based on our own tables, columns, custom logic, 
//then we need to create a bean that implements UserDetailsService and overrides the method loadUserByUsername.
@Service
@AllArgsConstructor
public class ProjectUserDetailsManager implements UserDetailsService {

	private final CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		List<Customer> customers = customerRepository.findByUsername(username);
		if (null == customers || customers.isEmpty()) {
			throw new UsernameNotFoundException("User not found, please verify this username: " + username);
		} else {
			Customer customer = customers.get(0);
			String userName = customer.getUsername();
			String password = customer.getPassword();
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customer.getRole().name()));
			user = new User(userName, password, authorities);
		}
		return user;
	}
	
}
