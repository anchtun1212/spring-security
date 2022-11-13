package com.anchtun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactDetails {

	@GetMapping("/contact")
	public String saveContactDetails() {
		return "Save contact details";
	}
}
