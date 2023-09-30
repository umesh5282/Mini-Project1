package com.umesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umesh.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
