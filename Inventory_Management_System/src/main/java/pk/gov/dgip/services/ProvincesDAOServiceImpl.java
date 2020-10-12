package pk.gov.dgip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.gov.dgip.entities.Province;
import pk.gov.dgip.repos.ProvincesRepository;

@Service
public class ProvincesDAOServiceImpl implements ProvincesDAOService {
	@Autowired
	private ProvincesRepository provincesRep;
	@Override
	public Province saveProvince(Province province) {
		return provincesRep.save(province);
	}

	@Override
	public Province updateProvince(Province province) {
		return provincesRep.save(province);
	}

	@Override
	public void deleteProvince(Province province) {
		provincesRep.delete(province);
	}

	@Override
	public Province getProvinceById(long id) {
		return provincesRep.findById(id).get();
	}

	@Override
	public List<Province> getAllProvinces() {
		return provincesRep.findAll();
	}
	
}
