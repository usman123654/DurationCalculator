package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Category;

public interface CategoryDAOService {
	Category saveCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategory(Category category);
	Category getCategoryById(long id);
	List<Category> getAllCategories();
}
