package pk.gov.dgip.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Section;
import pk.gov.dgip.repos.SectionRepository;

@Service
public class SectionDAOServiceImpl implements SectionDAOService {

	@Autowired
	private SectionRepository sectionRep;
	@Override
	public Section saveSection(Section section) {
		return sectionRep.save(section);
	}

	@Override
	public Section updateSection(Section section) {
		return sectionRep.save(section);
	}

	@Override
	public void deleteSection(Section section) {
		       sectionRep.delete(section);
	}

	@Override
	public Section getSectionById(long id) {
		return sectionRep.findById(id).get();
	}

	@Override
	public List<Section> getAllSections() {
		return sectionRep.findAll();
	}
}
