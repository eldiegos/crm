package io.code.crm.rest.contact.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.contact.ContactDTO;
import io.code.crm.core.service.contact.IContactService;
import io.code.crm.rest.exception.CrmRestException;

@RestController
public class ContactController {

	@Autowired
	private IContactService contactService;

	
	
	@GetMapping("/api/contacts/{id}")
	public ResponseEntity<ContactDTO> getContact(@PathVariable(value = "id") String id) {

		ResponseEntity<ContactDTO> result = null;

		if (id == null || id.isBlank()) {
			throw new CrmRestException(HttpStatus.BAD_REQUEST, "Param id is required");
		}

		ContactDTO element;
		try {
			element = contactService.getByUuid(id); //  .getByUuid(id);
			result = ResponseEntity.ok(element);
			
		} catch (EntityNotFoundException e) {
			throw new CrmRestException(HttpStatus.NOT_FOUND, "Country not found");
		} catch (Exception e) {
			throw new CrmRestException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		

		return result;
	}
	
	
	@GetMapping("/api/contacts")
	public ResponseEntity<List<ContactDTO>> getCountries() {

		ResponseEntity<List<ContactDTO>> result = null;

		 contactService.getContactList();
		
		List<ContactDTO> elements = contactService.getContactList();
		result = ResponseEntity.ok(elements);

		return result;
	}
}