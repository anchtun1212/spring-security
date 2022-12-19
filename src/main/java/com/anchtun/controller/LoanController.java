package com.anchtun.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
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

	// you can add @PreAuthorize and @PostAuthorize at service layer or repository layer as well
	// @PostAuthorize("hasRole('USER')")
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/myLoans")
	public List<Loan> getLoanDetails(@RequestParam String email) {
		return loanService.findByCustomerEmailOrderByStartDtDesc(email);
	}
}
