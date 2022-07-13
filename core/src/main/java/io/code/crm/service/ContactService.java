package io.code.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.code.crm.model.contact.Contact;
import io.code.crm.model.contact.ContactNotFoundException;
import lombok.extern.java.Log;

@Log
@Service
@Primary
@Qualifier("dataServiceRepo")
public class ContactService implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact getContact(UUID id) throws ContactNotFoundException {

		log.info("Using DataServiceRepo Data Access");

        Contact c;

		Optional<Contact> opUser = contactRepository.findById(id);
		if (opUser.isPresent()) {

			c = opUser.get();
			
		} else
			throw new ContactNotFoundException("The contact does not exists");

		return c;
	}

    @Override
    public List<Contact> getContactList() {
        return this.contactRepository.findAll();
    }
}