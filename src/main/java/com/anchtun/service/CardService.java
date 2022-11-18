package com.anchtun.service;

import java.util.List;

import com.anchtun.model.Card;

public interface CardService {

	List<Card> findByCustomerId(Long customerId);

}
