package io.code.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.code.model.contact.Contact;
import io.code.service.IContactService;

@RestController
public class ContactController {

	@Autowired
	@Qualifier("dataServiceRepo")
	IContactService contactService;

	
	@GetMapping("/api/contacts")
	
	public List<Contact> getContacts() {
		return contactService.getContactList();
	}

}