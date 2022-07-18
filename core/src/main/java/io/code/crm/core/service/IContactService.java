package io.code.crm.core.service;


import java.util.List;
import java.util.UUID;

import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.model.contact.ContactNotFoundException;

public interface IContactService {

	List<Contact> getContactList();

	Contact getContact(UUID id) throws ContactNotFoundException;

}