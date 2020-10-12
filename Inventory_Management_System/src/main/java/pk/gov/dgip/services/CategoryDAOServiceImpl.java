package pk.gov.dgip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.gov.dgip.entities.Category;
import pk.gov.dgip.repos.CategoryRepository;

@Service
public class CategoryDAOServiceImpl implements CategoryDAOService{
	@Autowired
	private CategoryRepository catRep;
	
	@Override
	public Category saveCategory(Category category) {
		return catRep.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return catRep.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		catRep.delete(category);
	}

	@Override
	public Category getCategoryById(long id) {
		return catRep.findById(id).get();
	}

	@Override
	public List<Category> getAllCategories() {
		return catRep.findAll();
	}

}
