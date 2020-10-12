package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Section;

public interface SectionDAOService {
	Section saveSection(Section section);
	Section updateSection(Section section);
	void deleteSection(Section section);
	Section getSectionById(long id);
	List<Section> getAllSections();
}
