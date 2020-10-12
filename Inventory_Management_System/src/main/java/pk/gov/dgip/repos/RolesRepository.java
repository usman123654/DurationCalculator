package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role,Long>{

}
