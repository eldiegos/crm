package io.code.crm.core.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.code.crm.core.model.contact.Contact;
import io.code.crm.core.model.contact.ContactRepository;
import lombok.extern.java.Log;

@Log
@Configuration
public class ContactsDataInitializer {

	@Autowired 
	private ContactRepository repo;

    @Bean
    void loadDemoContacts() {

        Contact c0 = new Contact("Alison", "Parker");
        Contact c1 = new Contact("Amy", "White");
        Contact c2 = new Contact("Bella", "Black");
        Contact c3 = new Contact("Caroline", "Madison");
        Contact c4 = new Contact("Paco", "García").withSurname2("Sevilla");
        Contact c5 = new Contact("José", "Pérez").withSurname2("Poncho");

        List<Contact> list = List.of(c0, c1, c2, c3, c4, c5);
        repo.saveAll(list);
        
        log.fine("Contacts demo data loaded");
    }

}
