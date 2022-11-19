package com.anchtun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
