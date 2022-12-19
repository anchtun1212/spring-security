package com.anchtun.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anchtun.model.Loan;
import com.anchtun.repository.LoanRepository;
import com.anchtun.service.LoanService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {
	
	private final LoanRepository loanRepository;

	@Override
	public List<Loan> findByCustomerIdOrderByStartDtDesc(Long customerId) {
		return loanRepository.findByCustomerIdOrderByStartDateDesc(customerId);
	}

	@Override
	public List<Loan> findByCustomerEmailOrderByStartDtDesc(String email) {
		return loanRepository.findByCustomerEmailOrderByStartDateDesc(email);
	}

}
