package com.anchtun.service;

import java.util.List;

import com.anchtun.model.AccountTransaction;

public interface AccountTransactionService {

	List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(Long customerId);

}
