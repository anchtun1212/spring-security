package com.anchtun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.anchtun.enums.AccountType;

@Entity
public class Account extends BaseEntity {

	@Id
	private Long Number;
	
	@Enumerated(EnumType.STRING)
	private AccountType Type;

	@Column(name = "branch_address")
	private String branchAddress;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
