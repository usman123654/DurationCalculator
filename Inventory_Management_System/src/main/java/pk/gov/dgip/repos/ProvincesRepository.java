package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Province;

@Repository
public interface ProvincesRepository extends JpaRepository<Province,Long> {

}
