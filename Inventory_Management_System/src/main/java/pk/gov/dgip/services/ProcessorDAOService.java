package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Processor;

public interface ProcessorDAOService {
	Processor saveProcessor(Processor Processor);
	Processor updateProcessor(Processor Processor);
	void deleteProcessor(Processor Processor);
	Processor getProcessorById(long id);
	List<Processor> getAllProcessors();
	List<Processor> findAllByOrderByNameAsc();
}
