package com.anchtun.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Notice;
import com.anchtun.service.NoticeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class NoticeController {
	
	private final NoticeService noticeService;

	@GetMapping("/notices")
	public ResponseEntity<List<Notice>> getNotices() {
		return noticeService.findAllActiveNotices();
	}
}
