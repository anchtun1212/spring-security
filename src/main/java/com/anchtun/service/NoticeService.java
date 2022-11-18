package com.anchtun.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.anchtun.model.Notice;

public interface NoticeService {

	ResponseEntity<List<Notice>> findAllActiveNotices();

}
