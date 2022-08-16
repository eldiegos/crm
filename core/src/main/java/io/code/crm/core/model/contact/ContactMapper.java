package io.code.crm.core.model.contact;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ContactDTO toDTO(Contact contact) {
		return Objects.isNull(contact) ? null : modelMapper.map(contact, ContactDTO.class);
	}

	public Contact toEntity(ContactDTO contactDTO) {
		return Objects.isNull(contactDTO) ? null : modelMapper.map(contactDTO, Contact.class);
	}

	public List<ContactDTO> toDTO(List<Contact> contacts) {
		return contacts.stream().map(c -> modelMapper.map(c, ContactDTO.class)).collect(Collectors.toList());
	}
}
