package io.code.crm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.service.ContactService;

@SpringBootTest
class CrmApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ContactService contactService;
	
	@Test
	void testGetAllContacts(){

		List<Contact> contactList = this.contactService.getContactList();
		for(Contact cc : contactList){
			System.out.println(cc.toString());
		}
		assertTrue(contactList!=null && !contactList.isEmpty());
	}

}
