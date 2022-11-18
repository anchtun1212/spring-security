package com.anchtun.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.anchtun.model.Notice;
import com.anchtun.repository.NoticeRepository;
import com.anchtun.service.NoticeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;

	@Override
	public ResponseEntity<List<Notice>> findAllActiveNotices() {
		List<Notice> notices = noticeRepository.findAllActiveNotices();
		if (notices != null) {
			return ResponseEntity.ok().
					// will keep the result 60 seconds so if the user ask for this result in 60 seconds will get it from the cache
					cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(notices);
		} else {
			return null;
		}
	}

}
