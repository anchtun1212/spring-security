package com.anchtun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	private String welcome() {
		return "Welcome to Anchtun's Spring security repository !!!";
	}
}
