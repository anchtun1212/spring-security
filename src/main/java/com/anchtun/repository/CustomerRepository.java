package com.anchtun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// derived method name query
	Customer findOneByUsername(String username);
}
