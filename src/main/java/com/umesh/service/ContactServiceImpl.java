package com.umesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umesh.entity.Contact;
import com.umesh.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
              
	@Autowired
	private ContactRepository repo;
	@Override
	public String upsert(Contact contact) {
	Contact save = repo.save(contact);
		return "success" ;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		Optional<Contact> findById = repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String deleteContact(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "success";
	}

}
