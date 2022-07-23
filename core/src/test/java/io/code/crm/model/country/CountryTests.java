package io.code.crm.model.country;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.code.crm.core.model.country.Country;
import io.code.crm.core.service.country.CountryService;
import io.code.crm.core.service.country.ICountryService;

@SpringBootTest
class CountryTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ICountryService countryService;

	@Test
	void testGetAllContacts() {

		List<Country> rList = this.countryService.getCountryList();
		for (Country cc : rList) {
			System.out.println(cc.toString());
		}
		assertTrue(rList != null && !rList.isEmpty());
	}

	@Test
	void testGetCountryByCode2() {

		Country cc = this.countryService.getCountryByCode2("ES");

		System.out.println(cc.toString());

		assertTrue(cc.getCod2().equalsIgnoreCase("ES"));
	}
	
	@Test
	void testGetCountryByCode3() {

		Country cc = this.countryService.getCountryByCode3("ESP");

		System.out.println(cc.toString());

		assertTrue(cc.getCod3().equalsIgnoreCase("ESP"));
	}
}
