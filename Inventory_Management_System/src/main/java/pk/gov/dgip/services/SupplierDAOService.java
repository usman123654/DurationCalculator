package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Supplier;

public interface SupplierDAOService {
	Supplier saveSupplier(Supplier supplier);
	Supplier updateSupplier(Supplier supplier);
	void deleteSupplier(Supplier supplier);
	Supplier getSupplierById(long id);
	List<Supplier> getAllSuppliers();
}
