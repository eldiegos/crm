package io.code.crm.model.country;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import io.code.crm.core.model.country.Country;
import io.code.crm.core.model.country.CountryRepository;

@SpringBootTest
class CountryRepoTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CountryRepository countryRepository;

	@Test
	void testGetAllCountries() {

		List<Country> cList = this.countryRepository.findAll();
		cList.stream().forEach(c -> System.out.println(c));
		assertTrue(cList != null && !cList.isEmpty());
	}

	@Test
	void testGetCountryByCode2() {

		Country cc = this.countryRepository.findByCod2("ES");

		System.out.println(cc.toString());

		assertTrue(cc.getCod2().equalsIgnoreCase("ES"));
	}
	
	@Test
	void testGetCountryByCode3() {

		Country cc = this.countryRepository.findByCod3("ESP");

		System.out.println(cc.toString());

		assertTrue(cc.getCod3().equalsIgnoreCase("ESP"));
	}
	
	@Test
	void testGetCountryByName() {

		Country cc = this.countryRepository.findByName("Spain");

		System.out.println(cc.toString());

		assertTrue(cc.getName().equalsIgnoreCase("Spain"));
	}
	
	
	@Test
	void testGetAllCountriesSortedAscending() {

		List<Country> cList = this.countryRepository.findAll(Sort.by("name").ascending());
		cList.stream().forEach(c -> System.out.println(c));

	}
}
