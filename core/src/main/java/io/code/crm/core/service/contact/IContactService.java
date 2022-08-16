package io.code.crm.core.service.contact;


import java.util.List;
import java.util.UUID;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.contact.ContactDTO;

public interface IContactService {

	List<ContactDTO> getContactList();

	ContactDTO getByUuid(String id) throws EntityNotFoundException;

}