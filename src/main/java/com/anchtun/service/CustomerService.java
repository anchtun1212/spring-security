package com.anchtun.service;

import org.springframework.http.ResponseEntity;

import com.anchtun.model.Customer;

public interface CustomerService {

	ResponseEntity<?> save(Customer customer);
}
