package pk.gov.dgip.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Supplier;
import pk.gov.dgip.repos.SupplierRepository;

@Service
public class SupplierDAOServiceImpl implements SupplierDAOService {
	@Autowired
	private SupplierRepository suppRep;
	
	@Override
	public Supplier saveSupplier(Supplier supplier) {
		return suppRep.save(supplier);
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		return suppRep.save(supplier);
	}

	@Override
	public void deleteSupplier(Supplier supplier) {
		suppRep.delete(supplier);
	}

	@Override
	public Supplier getSupplierById(long id) {
		return suppRep.findById(id).get();
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return suppRep.findAll();
	}

}
