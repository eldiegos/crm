package io.code.crm.model.contact;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.model.contact.ContactDao;
import io.code.crm.core.service.contact.ContactService;

@SpringBootTest
class ContactTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ContactService contactService;
	
	@Test
	void testGetAllContacts(){

		List<Contact> rList = this.contactService.getContactList();
		for(Contact cc : rList){
			System.out.println(cc.toString());
		}
		assertTrue(rList!=null && !rList.isEmpty());
	}

	
	@Autowired
	ContactDao contactDao;
	
	@Test
	void testGetAllContactsCQ(){

		List<Contact> rList = this.contactDao.findContacts("Joh", "Smit");
		rList.stream().forEach(c -> System.out.println(c.toString()));
		assertTrue(rList!=null && !rList.isEmpty());
	}
	
}
