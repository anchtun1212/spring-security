package com.anchtun.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Contact;
import com.anchtun.service.ContactService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ContactController {
	
	private final ContactService contactService;

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
    	return contactService.save(contact);
    }
}
