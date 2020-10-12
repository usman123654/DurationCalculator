package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Category;
import pk.gov.dgip.entities.Manufacturer;

public interface ManufacturerDAOService {
	Manufacturer saveManufacturer(Manufacturer manufacturer);
	Manufacturer updateManufacturer(Manufacturer manufacturer);
	void deleteManufacturer(Manufacturer manufacturer);
	Manufacturer getManufacturerById(long id);
	List<Manufacturer> getAllManufacturers();
}
