package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long>{

}
