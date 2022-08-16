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
import io.code.crm.core.model.contact.ContactDTO;
import io.code.crm.core.model.contact.ContactException;
import io.code.crm.core.model.contact.ContactMapper;
import io.code.crm.core.model.contact.ContactRepository;
import lombok.extern.java.Log;

@Log
@Service
@Primary
@Qualifier("dataServiceRepo")
public class ContactService implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactMapper contactMapper;

    @Override
    public List<ContactDTO> getContactList() {
        
    	List<Contact> contacts = this.contactRepository.findAll();
        return this.contactMapper.toDTO(contacts);
    }

	@Override
	public ContactDTO getByUuid(String id) throws EntityNotFoundException {
		
		log.fine("Using DataServiceRepo Data Access");

		ContactDTO dto;

		UUID uid = UUID.fromString(id);
		Optional<Contact> opUser = contactRepository.findById(uid);
		if (opUser.isPresent()) {

			Contact c = opUser.get();
			dto = this.contactMapper.toDTO(c);
			
		} else
			throw new EntityNotFoundException(Contact.class, "The contact does not exists");

		return dto;
	}
}