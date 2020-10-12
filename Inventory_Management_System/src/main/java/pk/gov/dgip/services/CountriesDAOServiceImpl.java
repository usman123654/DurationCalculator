package pk.gov.dgip.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Country;
import pk.gov.dgip.repos.CountriesRepository;

@Service
public class CountriesDAOServiceImpl implements CountriesDAOService {

	@Autowired
	private CountriesRepository countryRep;
	
	@Override
	public Country saveCountry(Country country) {
		return countryRep.save(country);
	}

	@Override
	public Country updateCountry(Country country) {
		return countryRep.save(country);
	}

	@Override
	public void deleteCountry(Country country) {
			   countryRep.delete(country);
	}

	@Override
	public Country getCountryById(long id) {
		return countryRep.findById(id).get();
	}

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return countryRep.findAll();
	}

}
