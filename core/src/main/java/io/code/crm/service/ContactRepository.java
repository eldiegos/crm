package io.code.crm.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.code.crm.model.contact.Contact;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}