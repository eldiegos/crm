package io.code.crm.core.service.country;


import java.util.List;
import java.util.UUID;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.country.Country;

public interface ICountryService {


	Country getByUuid(UUID id) throws EntityNotFoundException;

	List<Country> getCountryList();

	Country getCountryByCode2(String code2);

}