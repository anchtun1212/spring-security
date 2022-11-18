package com.anchtun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

	@Query(nativeQuery = true, value = "select * from notice_details where now() BETWEEN begin_Date AND end_Date")
	List<Notice> findAllActiveNotices();
}
