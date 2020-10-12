package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.gov.dgip.entities.Role;

public interface UserRolesRepository extends JpaRepository<Role,Long> {

}
