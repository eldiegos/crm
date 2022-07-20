package io.code.crm.rest.contact.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.service.contact.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	
	@GetMapping("/api/contacts")
	public List<Contact> getContacts() {
		return contactService.getContactList();
	}

}