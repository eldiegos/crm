package io.code.crm.core.model.contact;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}