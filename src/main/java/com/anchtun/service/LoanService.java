package com.anchtun.service;

import java.util.List;

import com.anchtun.model.Loan;

public interface LoanService {

	List<Loan> findByCustomerIdOrderByStartDtDesc(Long customerId);

}
