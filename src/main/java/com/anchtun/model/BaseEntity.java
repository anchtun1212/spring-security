package com.anchtun.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
//indicates to spring data jpa that all the entities that extends this class please treat those fields as columns
@MappedSuperclass
//this tell spring data jpa: treat this BaseEntity as an entity that supports auditing inside my web application.
@EntityListeners(AuditingEntityListener.class)
//don't send (ignore) those fields in the response (REST services)
//@JsonIgnoreProperties(value = {"createdAt", "createdBy", "updatedAt", "updatedBy"}
public class BaseEntity {
	
	@CreatedDate
	@Column(updatable = false, name = "create_date")
	// commented because this field was added in @JsonIgnoreProperties
	//@JsonIgnore
	private LocalDate createDate;
	
}
