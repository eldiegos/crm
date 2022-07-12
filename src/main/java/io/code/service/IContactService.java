package io.code.service;


import java.util.List;
import java.util.UUID;

import io.code.model.contact.Contact;
import io.code.model.contact.ContactNotFoundException;

public interface IContactService {

	List<Contact> getContactList();

	Contact getContact(UUID id) throws ContactNotFoundException;

}