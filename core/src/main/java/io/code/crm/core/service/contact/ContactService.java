package io.code.crm.core.service.contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.model.contact.ContactException;
import io.code.crm.core.model.contact.ContactRepository;
import lombok.extern.java.Log;

@Log
@Service
@Primary
@Qualifier("dataServiceRepo")
public class ContactService implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	

    @Override
    public List<Contact> getContactList() {
        return this.contactRepository.findAll();
    }

	@Override
	public Contact getByUuid(UUID id) throws EntityNotFoundException {
		
		log.fine("Using DataServiceRepo Data Access");

        Contact c;

		Optional<Contact> opUser = contactRepository.findById(id);
		if (opUser.isPresent()) {

			c = opUser.get();
			
		} else
			throw new EntityNotFoundException(Contact.class, "The contact does not exists");

		return c;
	}
}