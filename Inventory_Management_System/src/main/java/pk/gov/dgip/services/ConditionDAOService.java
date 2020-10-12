package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Condition;

public interface ConditionDAOService {
	Condition saveCondition(Condition condition);
	Condition updateCondition(Condition condition);
	void deleteCondition(Condition condition);
	Condition getConditionById(long id);
	List<Condition> getAllConditions();
}