package pk.gov.dgip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Address;
import pk.gov.dgip.repos.AddressRepository;

@Service
public class AddressDAOServiceImpl implements AddressDAOService {
	@Autowired
	private AddressRepository addressRepository;
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddress(Address address) {
		addressRepository.delete(address);
	}

	@Override
	public Address getAddressById(long id) {
		return addressRepository.findById(id).get();
	}

	@Override
	public List<Address> getAllCategories() {
		return addressRepository.findAll();
	}	
}
