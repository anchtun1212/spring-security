package com.anchtun.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "contact_messages")
public class Contact extends BaseEntity {
	
	@Id
	private String id;
	
	private String name;
	
	private String email;
	
	private String subject;
	
	private String message;

}
