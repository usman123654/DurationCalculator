package pk.gov.dgip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Processor;
import pk.gov.dgip.repos.ProcessorRepository;

@Service
public class ProcessorDAOServiceImpl implements ProcessorDAOService {
	
	@Autowired
	private ProcessorRepository processorRepository;
	
	@Override
	public Processor saveProcessor(Processor processor) {
		return processorRepository.save(processor);
	}

	@Override
	public Processor updateProcessor(Processor processor) {
		return processorRepository.save(processor);
	}

	@Override
	public void deleteProcessor(Processor processor) {
		 processorRepository.delete(processor);
	}

	@Override
	public List<Processor> getAllProcessors() {
		return processorRepository.findAll();
	}

	@Override
	public Processor getProcessorById(long id) {
		return processorRepository.findById(id).get();
	}

	@Override
	public List<Processor> findAllByOrderByNameAsc() {
		return processorRepository.findAllByOrderByNameAsc();
	}
	
}
