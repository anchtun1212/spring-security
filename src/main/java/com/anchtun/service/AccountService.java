package com.anchtun.service;

import com.anchtun.model.Account;

public interface AccountService {

	Account findByCustomerId(int customerId);

}
