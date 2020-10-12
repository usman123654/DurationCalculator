package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
