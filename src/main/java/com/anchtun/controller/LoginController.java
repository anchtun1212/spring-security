package com.anchtun.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Customer;
import com.anchtun.service.CustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class LoginController {

	private final CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
    	return customerService.findByEmail(authentication.getName());
    }

}
