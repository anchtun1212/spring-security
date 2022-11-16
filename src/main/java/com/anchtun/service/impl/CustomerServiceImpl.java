package com.anchtun.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.anchtun.model.Customer;
import com.anchtun.repository.CustomerRepository;
import com.anchtun.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;

	@Override
	public ResponseEntity<?> save(Customer customer) {
		Customer saved = null;
		ResponseEntity<?> response = null;
		try {
			saved = customerRepository.save(customer);
			if (saved.getId() > 0L) {
				response = ResponseEntity
						.status(HttpStatus.CREATED)
						.body("User was successfully created");
			}
		} catch (Exception e) {
			log.error("Exception occured: " + e.getMessage());
			response = ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Exception occured due to: " + e.getMessage());
		}
		return response;
	}

}
