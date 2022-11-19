package com.anchtun.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.anchtun.enums.TransactionType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "account_transactions")
public class AccountTransaction extends BaseEntity {

	@Id
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name="transaction_date")
	private LocalDate transactionDate;
	
	@Column(name = "transaction_summary")
	private String transactionSummary;
	
	@Enumerated(EnumType.STRING)
	@Column(name="transaction_type")
	private TransactionType transactionType;
	
	@Column(name = "transaction_amount")
	private int transactionAmount;
	
	@Column(name = "closing_balance")
	private int closingBalance;
	
}
