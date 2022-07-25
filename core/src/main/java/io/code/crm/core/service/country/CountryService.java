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

import io.code.crm.core.model.EntityNotFoundException;
import io.code.crm.core.model.country.Country;
import io.code.crm.core.model.country.CountryRepository;
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
	public Country getByUuid(String id) throws EntityNotFoundException {

		log.fine("Using DataServiceRepo Data Access");

		Country obj;

		UUID uid = UUID.fromString(id);
		Optional<Country> opFind = countryRepository.findById(uid);
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
		// TODO Auto-generated method stub
		return null;
	}
    /*
    @Override
    public Country getCountryByCode2(String code2) {

    	
    	JPAQueryFactory  query = new JPAQueryFactory (em);
		QCountry country = QCountry.country;
		return (Country) query.from(country).where(country.cod2.eq(code2)).fetchOne();
    	
    }
*/
	@Override
	public Country getCountryByCode3(String code3) {
		
		List<Country> all = this.countryRepository.findAll();
		return all.stream()
				  .filter(country -> code3.equals(country.getCod3()))
				  .findAny()
				  .orElse(null);
		
	}

	
}