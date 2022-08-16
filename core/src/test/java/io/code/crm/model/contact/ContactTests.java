package io.code.crm.model.contact;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.model.contact.ContactDTO;
import io.code.crm.core.service.contact.IContactService;

@SpringBootTest
class ContactTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	IContactService contactService;
	
	@Test
	void testGetAllContacts(){

		List<ContactDTO> rList = this.contactService.getContactList();
		rList.stream().forEach(c -> System.out.println(c));
		assertTrue(rList!=null && !rList.isEmpty());
	}

	
	
	
}
