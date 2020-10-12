package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Address;


public interface AddressDAOService {
	Address saveAddress(Address Address);
	Address updateAddress(Address Address);
	void deleteAddress(Address Address);
	Address getAddressById(long id);
	List<Address> getAllCategories();
}
