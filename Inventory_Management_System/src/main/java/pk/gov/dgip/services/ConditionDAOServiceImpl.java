package pk.gov.dgip.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Condition;
import pk.gov.dgip.repos.ConditionRepository;

@Service
public class ConditionDAOServiceImpl implements ConditionDAOService {
	
	@Autowired
	private ConditionRepository conditionRep;

	@Override
	public Condition saveCondition(Condition condition) {
		return conditionRep.save(condition);
	}

	@Override
	public Condition updateCondition(Condition condition) {
		return conditionRep.save(condition);
	}

	@Override
	public void deleteCondition(Condition condition) {
		 conditionRep.delete(condition);
	}

	@Override
	public Condition getConditionById(long id) {
		return conditionRep.findById(id).get();
	}

	@Override
	public List<Condition> getAllConditions() {
		return conditionRep.findAll();
	}
}