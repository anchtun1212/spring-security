package com.anchtun.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Card;
import com.anchtun.service.CardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CardController {
	
	private final CardService cardService;

	@GetMapping("/myCards")
	public List<Card> getCardDetails(@RequestParam String email) {
		return cardService.findByCustomerEmail(email);
	}
}
