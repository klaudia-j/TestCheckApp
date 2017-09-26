package pl.jarno.web;

import java.util.List;

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
import pl.jarno.jsonclass.CategoryWithQuestions;
import pl.jarno.repository.CategoryRepository;
import pl.jarno.repository.QuestionRepository;
import pl.jarno.repository.UserRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private QuestionRepository questionRepo;

	
	
	@GetMapping("/")
	public List<Category> getCategories() {
		List<Category> list = categoryRepo.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable long id) {
		Category category = categoryRepo.findOne(id);
		return category;
	}
	
//	@GetMapping("/{id}")
//	public CategoryWithQuestions getCategory(@PathVariable long id) {
//		CategoryWithQuestions categoryWithQuestions = new CategoryWithQuestions();
//		categoryWithQuestions.setCategory(categoryRepo.findOne(id));
//		categoryWithQuestions.setQuestions(questionRepo.findByCategoryId(id));
//		return categoryWithQuestions;
//	}
	
	@PostMapping("/")
//	@ResponseStatus(HttpStatus.OK)
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
		categoryRepo.delete(id);
	}
	
}
