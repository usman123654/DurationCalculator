package pk.gov.dgip.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.repos.UserDataRepository;

@Service
public class UserDAOServiceImpl implements UserDAOService {
	
	@Autowired
	private UserDataRepository userRep;
	
	@Override
	public User saveUser(User user) {
		return userRep.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRep.save(user);
	}

	@Override
	public void deleteUser(User user) {
	    userRep.delete(user);
	}

	@Override
	public User getUserById(long id) {
		return userRep.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRep.findAll();
	}

	@Override
	public User findByNameAndPassword(String username, String password) {
		return userRep.findByNameAndPassword(username, password);
	}

	@Override
	public User findUserByFullName(String fullname) {
		return userRep.findByFullname(fullname);
	}	
}
