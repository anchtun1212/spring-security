package com.anchtun.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anchtun.model.AccountTransaction;
import com.anchtun.repository.AccountTransactionRepository;
import com.anchtun.service.AccountTransactionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountTransactionServiceImpl implements AccountTransactionService {
	
	private final AccountTransactionRepository accountTransactionRepository;

	@Override
	public List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(Long customerId) {
		return accountTransactionRepository.findByCustomerIdOrderByTransactionDateDesc(customerId);
	}

}
