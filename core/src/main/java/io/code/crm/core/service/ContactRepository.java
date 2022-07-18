package io.code.crm.core.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.code.crm.core.model.contact.Contact;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}