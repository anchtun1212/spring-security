package com.anchtun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Account;
import com.anchtun.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController {

	private final AccountService accountService;

	@GetMapping("/myAccount")
	public Account getAccountDetails(@RequestParam int customerId) {
		return accountService.findByCustomerId(customerId);
	}
}
