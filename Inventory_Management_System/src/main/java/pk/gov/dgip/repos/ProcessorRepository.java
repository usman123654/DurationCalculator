package pk.gov.dgip.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pk.gov.dgip.entities.Processor;

@Repository
public interface ProcessorRepository  extends JpaRepository<Processor,Long>{ 
	public List<Processor> findAllByOrderByNameAsc();
}
