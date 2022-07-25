package io.code.crm.model.contact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.model.contact.ContactDao;
import io.code.crm.core.model.contact.ContactRepository;
import io.code.crm.core.model.contact.ContactSpecs;
import io.code.crm.core.model.contact.Contact_;

@SpringBootTest
class ContactRepoTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ContactRepository repo;
	
	@Autowired
	ContactDao contactDao;
	
	@Test
	void testGetAllContactsCQ(){

		List<Contact> rList = this.contactDao.findContacts("Joh", "Smit");
		rList.stream().forEach(c -> System.out.println(c.toString()));
		assertTrue(rList!=null && !rList.isEmpty());
	}
	
	
	@Test
	void whenFindByLastNameAndFirstNameLike_thenOneContactIsReturned(){

		Specification<Contact> specification = ContactSpecs.hasLastName("Smith")
			      .and(ContactSpecs.hasFirstNameLike("Jo"));
		
		List<Contact> list = repo.findAll(specification, Sort.by(Contact_.NAME).ascending());
		list.stream().forEach(c -> System.out.println(c.toString()));
	    assertThat(list).hasSize(1);

	}
	
}
