package com.anchtun.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.anchtun.model.AccountTransaction;
import com.anchtun.model.Customer;
import com.anchtun.repository.AccountTransactionRepository;
import com.anchtun.repository.CustomerRepository;
import com.anchtun.service.AccountTransactionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountTransactionServiceImpl implements AccountTransactionService {

	private final AccountTransactionRepository accountTransactionRepository;
	private final CustomerRepository customerRepository;

	@Override
	public List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(Long customerId) {
		return accountTransactionRepository.findByCustomerIdOrderByTransactionDateDesc(customerId);
	}

	@Override
	public List<AccountTransaction> findByCustomerEmailOrderByTransactionDateDesc(String email) {
		Customer customer = customerRepository.findOneByEmail(email);
		if (Objects.nonNull(customer)) {
			return findByCustomerIdOrderByTransactionDateDesc(customer.getId());
		}
		return null;
	}

}
