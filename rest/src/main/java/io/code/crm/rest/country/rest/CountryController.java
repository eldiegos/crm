package io.code.crm.rest.country.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.country.Country;
import io.code.crm.core.service.country.ICountryService;
import io.code.crm.rest.exception.CrmRestException;

@RestController
public class CountryController {

	@Autowired
	private ICountryService countryService;

	

	@GetMapping("/api/countries/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable(value = "id") String id) {

		ResponseEntity<Country> result = null;

		if (id == null || id.isBlank()) {
			throw new CrmRestException(HttpStatus.BAD_REQUEST, "Param id is required");
		}

		Country element;
		try {
			element = countryService.getByUuid(id);
			result = ResponseEntity.ok(element);
			
		} catch (EntityNotFoundException e) {
			throw new CrmRestException(HttpStatus.NOT_FOUND, "Country not found");
		} catch (Exception e) {
			throw new CrmRestException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		

		return result;
	}
	
	
	@GetMapping("/api/countries")
	public ResponseEntity<List<Country>> getCountries() {

		ResponseEntity<List<Country>> result = null;

		List<Country> elements = countryService.getCountryList();
		result = ResponseEntity.ok(elements);

		return result;
	}

}