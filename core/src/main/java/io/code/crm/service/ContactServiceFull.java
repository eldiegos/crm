package io.code.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.code.crm.model.contact.Contact;
import lombok.extern.java.Log;

@Log
@Service
public class ContactServiceFull  {

	@Autowired
	private ContactRepository contactRepository;

	
    public List<Contact> getContactList() {
        return this.contactRepository.findAll();
    }
}