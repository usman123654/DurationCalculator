package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Province;

public interface ProvincesDAOService {
	Province saveProvince(Province province);
	Province updateProvince(Province Province);
	void deleteProvince(Province Province);
	Province getProvinceById(long id);
	List<Province> getAllProvinces();
}
