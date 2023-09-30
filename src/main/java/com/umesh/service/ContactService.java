package com.umesh.service;

import java.util.List;

import com.umesh.entity.Contact;

public interface ContactService {

	String upsert (Contact contact);
	
	List<Contact>getAllContacts();
	
	Contact getContact(int id);
	
	String deleteContact(int id);
	
}
