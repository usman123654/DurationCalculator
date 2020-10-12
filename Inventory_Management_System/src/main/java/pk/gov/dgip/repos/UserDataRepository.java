package pk.gov.dgip.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pk.gov.dgip.entities.User;

@Repository
public interface UserDataRepository extends JpaRepository<User,Long>{
	User findByNameAndPassword(String username,String password);
    @Query("select u from User u where u.fullname = ?1")
	User findByFullname(String fullname);
    
}
