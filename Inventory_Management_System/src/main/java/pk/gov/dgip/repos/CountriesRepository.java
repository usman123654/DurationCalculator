package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Country;


@Repository
public interface CountriesRepository extends JpaRepository<Country,Long>{

}
