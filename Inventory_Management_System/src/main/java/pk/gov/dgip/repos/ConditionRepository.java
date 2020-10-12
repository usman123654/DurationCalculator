package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Category;
import pk.gov.dgip.entities.City;
import pk.gov.dgip.entities.Condition;

@Repository
public interface ConditionRepository extends JpaRepository<Condition,Long>{

}
