package io.code.crm.core.service.contact;


import java.util.List;
import java.util.UUID;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.contact.Contact;

public interface IContactService {

	List<Contact> getContactList();

	Contact getByUuid(UUID id) throws EntityNotFoundException;

}