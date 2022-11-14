package com.anchtun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// derived method name query
	List<Customer> findByUsername(String username);
}
