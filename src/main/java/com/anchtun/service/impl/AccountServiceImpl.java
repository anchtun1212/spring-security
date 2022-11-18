package com.anchtun.service.impl;

import org.springframework.stereotype.Service;

import com.anchtun.model.Account;
import com.anchtun.repository.AccountRepository;
import com.anchtun.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	@Override
	public Account findByCustomerId(int customerId) {
		return accountRepository.findByCustomerId(customerId);
	}

}
