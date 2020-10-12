package pk.gov.dgip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.gov.dgip.entities.Manufacturer;
import pk.gov.dgip.repos.ManufacturerRepository;

@Service
public class ManufacturerDAOServiceImpl implements ManufacturerDAOService {

	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Override
	public Manufacturer saveManufacturer(Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

	@Override
	public Manufacturer updateManufacturer(Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

	@Override
	public void deleteManufacturer(Manufacturer manufacturer) {
		 manufacturerRepository.delete(manufacturer);		
	}

	@Override
	public Manufacturer getManufacturerById(long id) {
		return manufacturerRepository.findById(id).get();
	}

	@Override
	public List<Manufacturer> getAllManufacturers() {
		return manufacturerRepository.findAll();
	}
}
