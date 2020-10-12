package pk.gov.dgip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.gov.dgip.entities.Role;
import pk.gov.dgip.repos.RolesRepository;

@Service
public class RolesDAOServiceImpl implements RolesDAOService {
	
	@Autowired
	private RolesRepository rolesRep;
	
	@Override
	public Role saveRole(Role role) {
		return rolesRep.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		return rolesRep.save(role);
	}

	@Override
	public void deleteRole(Role role) {
		rolesRep.delete(role);
	}

	@Override
	public Role getRoleById(long id) {
		return rolesRep.findById(id).get();
	}

	@Override
	public List<Role> getAllRoles() {
		return rolesRep.findAll();
	}
}
