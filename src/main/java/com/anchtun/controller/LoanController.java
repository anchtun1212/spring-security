package com.anchtun.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Loan;
import com.anchtun.service.LoanService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanController {
	
	private final LoanService loanService;

	@GetMapping("/myLoans")
	public List<Loan> getLoanDetails(@RequestParam Long customerId) {
		return loanService.findByCustomerIdOrderByStartDtDesc(customerId);
	}
}
