package pk.gov.dgip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.gov.dgip.entities.City;
import pk.gov.dgip.repos.CityRepository;

@Service
public class CityDAOServiceImpl implements CityDAOService {

	@Autowired
	private CityRepository cityRep;
	@Override
	public City saveCity(City city) {
		return cityRep.save(city);
	}

	@Override
	public City updateCity(City city) {
		return cityRep.save(city);
	}

	@Override
	public void deleteCity(City city) {
		cityRep.delete(city);
	}

	@Override
	public City getCityById(long id) {
		return cityRep.findById(id).get();
	}

	@Override
	public List<City> getAllCities() {
		return cityRep.findAll();
	}
}
