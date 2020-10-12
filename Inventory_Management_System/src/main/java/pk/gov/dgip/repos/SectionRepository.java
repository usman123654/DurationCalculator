package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {

}
