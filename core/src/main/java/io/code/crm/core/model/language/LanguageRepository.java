package io.code.crm.core.model.language;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
}