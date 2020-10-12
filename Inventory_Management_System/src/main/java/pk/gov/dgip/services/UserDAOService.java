package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.User;

public interface UserDAOService {
	User saveUser(User user);
	User updateUser(User user);
	void deleteUser(User user);
	User getUserById(long id);
	List<User> getAllUsers();
	User findByNameAndPassword(String username,String password);
	User findUserByFullName(String fullname);
}
