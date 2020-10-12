package pk.gov.dgip.services;

import java.util.List;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Role;


public interface RolesDAOService {
	Role saveRole(Role Role);
	Role updateRole(Role Role);
	void deleteRole(Role Role);
	Role getRoleById(long id);
	List<Role> getAllRoles();
}
