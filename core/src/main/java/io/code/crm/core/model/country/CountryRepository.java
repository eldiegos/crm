package io.code.crm.core.model.country;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}