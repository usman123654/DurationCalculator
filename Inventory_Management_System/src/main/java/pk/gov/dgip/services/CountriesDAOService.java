package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Country;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;

public interface CountriesDAOService {
	Country saveCountry(Country country);
	Country updateCountry(Country country);
	void deleteCountry(Country country);
	Country getCountryById(long id);
	List<Country> getAllCountries();
}
