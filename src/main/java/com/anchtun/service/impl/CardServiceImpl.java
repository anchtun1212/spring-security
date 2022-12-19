package com.anchtun.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anchtun.model.Card;
import com.anchtun.repository.CardRepository;
import com.anchtun.service.CardService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {
	
	private final CardRepository cardRepository;

	@Override
	public List<Card> findByCustomerId(Long customerId) {
		return cardRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Card> findByCustomerEmail(String email) {
		return cardRepository.findByCustomerEmail(email);
	}

}
