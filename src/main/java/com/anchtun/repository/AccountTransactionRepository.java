package com.anchtun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {

	List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(Long customerId);
}
