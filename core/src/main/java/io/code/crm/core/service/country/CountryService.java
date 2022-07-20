package io.code.crm.core.service.country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.country.Country;
import io.code.crm.core.model.country.CountryRepository;
import io.code.crm.core.model.country.QCountry;
import lombok.extern.java.Log;

@Log
@Service
@Primary
@Qualifier("dataServiceRepo")
public class CountryService implements ICountryService {

	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country getByUuid(UUID id) throws EntityNotFoundException {

		log.fine("Using DataServiceRepo Data Access");

		Country obj;

		Optional<Country> opFind = countryRepository.findById(id);
		if (opFind.isPresent()) {

			obj = opFind.get();
			
		} else
			throw new EntityNotFoundException(Country.class, "The country does not exists");

		return obj;
	}

    @Override
    public List<Country> getCountryList() {
        return this.countryRepository.findAll();
    }
    
    @Override
    public Country getCountryByCode2(String code2) {

    	JPAQueryFactory  query = new JPAQueryFactory (em);
		QCountry country = QCountry.country;
		

		Country result = (Country) query.from(country).where(country.cod2.eq(code2)).fetchOne();
		return result;
    	
    }
}