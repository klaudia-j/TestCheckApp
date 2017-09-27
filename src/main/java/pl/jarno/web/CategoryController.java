package pl.jarno.web;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import pl.jarno.entity.Category;
import pl.jarno.entity.Question;
import pl.jarno.jsonclass.CategoryDetails;
import pl.jarno.jsonclass.CategoryViewAll;
import pl.jarno.repository.CategoryRepository;
import pl.jarno.repository.QuestionRepository;

@Transactional
@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private QuestionRepository questionRepo;

	
//	@GetMapping("/")
//	public List<Category> getCategories() {
//		List<Category> listFromDatabase = categoryRepo.findAll();
//		return listFromDatabase;
//	}
	
	@GetMapping("/")
	public List<CategoryViewAll> getCategories() {
		List<Category> listFromDatabase = categoryRepo.findAll();
		List<CategoryViewAll> listToDisplay = new ArrayList<>();
		for (int i = 0; i < listFromDatabase.size(); i++) {
			CategoryViewAll category = new CategoryViewAll();
			category.setId(listFromDatabase.get(i).getId());
			category.setName(listFromDatabase.get(i).getName());
			category.setQuestionCount(questionRepo.countByCategoryId(listFromDatabase.get(i).getId()));
			listToDisplay.add(category);
		}
		return listToDisplay;
	}
	
	@GetMapping("/{id}")
	public CategoryDetails getCategoryDetails(@PathVariable long id) {
		Category categoryFromDatabase = categoryRepo.findOne(id);
		CategoryDetails categoryToDisplay = new CategoryDetails();
		categoryToDisplay.setId(categoryFromDatabase.getId());
		categoryToDisplay.setName(categoryFromDatabase.getName());
		categoryToDisplay.setQuestions(questionRepo.findByCategoryId(id));
		return categoryToDisplay;
	}
//	
//	@GetMapping("/{id}")
//	public CategoryWithQuestions getCategory(@PathVariable long id) {
//		CategoryWithQuestions categoryWithQuestions = new CategoryWithQuestions();
//		categoryWithQuestions.setCategory(categoryRepo.findOne(id));
//		categoryWithQuestions.setQuestions(questionRepo.findByCategoryId(id));
//		return categoryWithQuestions;
//	}
	
	@PostMapping("/")
	public Category createCategory(@RequestBody Category category) {
		categoryRepo.save(category);
		return category;
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable Long id) {
		category.setId(id);
		categoryRepo.save(category);
		return category;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable long id) {
		List<Question> questionsToDelete = questionRepo.findByCategoryId(id);
		questionRepo.delete(questionsToDelete);
		categoryRepo.delete(id);
	}
	
}
