package com.anchtun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByCustomerId(Long customerId);
}
