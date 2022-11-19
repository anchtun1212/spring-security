package com.anchtun.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.anchtun.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Customer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	//@JsonIgnore
	// only on write we can get the password (POST: LoginController.registerUser)
	// WRITE_ONLY: from UI to backend server BUT NOT from backend server to UI application
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@OneToMany(mappedBy = "customer")
	List<Account> accounts;
	
	@OneToMany(mappedBy = "customer")
	List<Card> cards;
	
	@OneToMany(mappedBy = "customer")
	List<Loan> loans;
	
	// this field will not be send to the UI application
	@JsonIgnore
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	Set<Authority> authorities;
}
