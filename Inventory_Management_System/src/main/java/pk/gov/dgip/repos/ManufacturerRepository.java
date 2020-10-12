package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long>{

}
