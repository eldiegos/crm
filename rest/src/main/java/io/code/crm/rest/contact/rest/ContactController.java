package io.code.crm.rest.contact.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.code.crm.model.contact.Contact;
import io.code.crm.service.ContactServiceFull;

@RestController
public class ContactController {

	@Autowired
	ContactServiceFull contactServiceFull;

	
	@GetMapping("/api/contacts")
	public List<Contact> getContacts() {
		return contactServiceFull.getContactList();
	}

}