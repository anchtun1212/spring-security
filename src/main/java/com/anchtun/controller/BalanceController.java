package com.anchtun.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.AccountTransaction;
import com.anchtun.service.AccountTransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BalanceController {
	
	private final AccountTransactionService accountTransactionService;
	
	@GetMapping("/myBalance")
	public List<AccountTransaction> getBalanceDetails(@RequestParam Long customerId) {
		return accountTransactionService.findByCustomerIdOrderByTransactionDateDesc(customerId);
	}
}
