package io.code.crm.core.service.country;


import java.util.List;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.country.Country;

public interface ICountryService {


	Country getByUuid(String id) throws EntityNotFoundException;

	List<Country> getCountryList();

	Country getCountryByCode2(String code2);
	
	Country getCountryByCode3(String code3);

}