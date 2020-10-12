package pk.gov.dgip.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;

@Repository
public interface ItemsDataRepository extends JpaRepository<Item,Long> {
	@Query("select i from Item i where i.user = :user order by i.category.name asc")
	List<Item> findItemsByUser(User user);
	Item findBySerialNo(String serialno);
	Item findByServiceTagNo(String serviceTagNo);
	
}
