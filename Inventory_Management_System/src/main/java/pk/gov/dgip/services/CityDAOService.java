package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.City;

public interface CityDAOService {
	City saveCity(City city);
	City updateCity(City city);
	void deleteCity(City city);
	City getCityById(long id);
	List<City> getAllCities();
}
