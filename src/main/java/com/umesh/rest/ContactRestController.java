package com.umesh.rest;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.AbstractListenerWriteFlushProcessor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umesh.entity.Contact;
import com.umesh.service.ContactService;
@RestController
public class ContactRestController {
         @Autowired 
         private ContactService service;
         
         @PostMapping("/contact")
         public ResponseEntity<String>contact(@RequestBody Contact contact){
        	 String status =service.upsert(contact);
        	 return new ResponseEntity<>(status,HttpStatus.CREATED);
        			 
         }
         
         @GetMapping("/contacts")
         public ResponseEntity<List<Contact >> getAllContacts(){
			List<Contact> allContacts = service.getAllContacts();
        	 return new ResponseEntity<>(allContacts,HttpStatus.OK);
        	 
         }
        
         @GetMapping("/contact/{id}")
         public ResponseEntity<Contact>getContact(@PathVariable int id){
        	 Contact contact = service.getContact(id);
        	 return new ResponseEntity<>(contact,HttpStatus.OK);
         }
         
         @DeleteMapping("/contact/{id}")
         public ResponseEntity<String>deletContact(@PathVariable int id){
        	String deleteContact = service.deleteContact(id);
        	return new ResponseEntity<>(deleteContact,HttpStatus.OK);
         }
         
}
