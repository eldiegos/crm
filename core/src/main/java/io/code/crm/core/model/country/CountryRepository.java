package io.code.crm.core.model.country;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, UUID> {
	
	Country findByName(String name);
	Country findByCod2(String cod2);
	Country findByCod3(String cod3);
}