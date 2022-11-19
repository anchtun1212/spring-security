package com.anchtun.service.impl;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.anchtun.model.Contact;
import com.anchtun.repository.ContactRepository;
import com.anchtun.service.ContactService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;

	@Override
	public Contact save(Contact contact) {
		contact.setId(getServiceReqNumber());
		contact.setCreateDate(LocalDate.now());
		return contactRepository.save(contact);
	}

	private String getServiceReqNumber() {
		Random random = new Random();
		int ranNum = random.nextInt(999999999 - 9999) + 9999;
		return "SR" + ranNum;
	}

}
