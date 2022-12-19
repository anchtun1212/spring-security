package com.anchtun.service;

import com.anchtun.model.Customer;

public interface CustomerService {

	// comment because we are giving the responsibility of authentication to the Keycloak server.
	// ResponseEntity<?> save(Customer customer);
	
	Customer findByEmail(String email);
}
