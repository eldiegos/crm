package io.code.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.code.model.contact.Contact;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}