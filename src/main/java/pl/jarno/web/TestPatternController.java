package pl.jarno.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.jarno.entity.CategoryUsedInTestPattern;
import pl.jarno.entity.TestPattern;
import pl.jarno.jsonclass.CategoryViewAll;
import pl.jarno.jsonclass.TestPatternDetails;
import pl.jarno.jsonclass.TestPatternJson;
import pl.jarno.repository.CategoryRepository;
import pl.jarno.repository.CategoryUsedInTestPatternRepository;
import pl.jarno.repository.TestPatternRepository;

@Transactional
@RestController
@RequestMapping("/testPatterns")
public class TestPatternController {
	
	@Autowired
	TestPatternRepository testPatternRepo;
	@Autowired
	CategoryUsedInTestPatternRepository cuitpRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	@GetMapping("/")
	public List<TestPatternJson> getTestPatterns() {
		List<TestPattern> listFromDatabase = testPatternRepo.findAll();
		List<TestPatternJson> listToDisplay = new ArrayList<>();
		for (int i = 0; i < listFromDatabase.size(); i++) {
			TestPatternJson pattern = new TestPatternJson();
			pattern.setId(listFromDatabase.get(i).getId());
			pattern.setTitle(listFromDatabase.get(i).getTitle());
			pattern.setIsSingleChoice(listFromDatabase.get(i).isSingleChoice());
			listToDisplay.add(pattern);
		}
		return listToDisplay;
	}
	
	@GetMapping("/{id}")
	public TestPatternDetails getTestPatternDetails(@PathVariable Long id) {
		TestPattern testFromDatabase = testPatternRepo.findOne(id);
		TestPatternDetails testToDisplay = new TestPatternDetails();
		testToDisplay.setId(id);
		testToDisplay.setTitle(testFromDatabase.getTitle());
		testToDisplay.setTeacherName(testFromDatabase.getTeacherName());
		testToDisplay.setIsNameRequired(testFromDatabase.isNameRequired());
		testToDisplay.setIsIdRequired(testFromDatabase.isIdRequired());
		testToDisplay.setIsSingleChoice(testFromDatabase.isSingleChoice());
		testToDisplay.setAdditionalInformation(testFromDatabase.getAdditionalInformation());
		testToDisplay.setCreatedDate(testFromDatabase.getCreatedDate());
		testToDisplay.setGradingMethod(testFromDatabase.getGradingMethod());
		List <CategoryUsedInTestPattern> categoriesFromDatabase = cuitpRepo.findAllByTestPatternId(id);
		List<CategoryViewAll> categoriesToDisplay = new ArrayList<>();
		for (int i = 0; i < categoriesFromDatabase.size(); i++) {
			CategoryViewAll category = new CategoryViewAll();
			category.setId(categoriesFromDatabase.get(i).getId());
//			category.setName(categoriesFromDatabase.get(i).getName());
		}
		return testToDisplay;
	}
	
	@PostMapping("/")
	public TestPatternDetails createTestPattern(@RequestBody TestPatternDetails testPattern) {
		TestPattern testPatternToDatabase = new TestPattern();
		testPatternToDatabase.setTitle(testPattern.getTitle());
		testPatternToDatabase.setTeacherName(testPattern.getTeacherName());
		testPatternToDatabase.setIsNameRequired(testPattern.isNameRequired());
		testPatternToDatabase.setIsIdRequired(testPattern.isIdRequired());
		testPatternToDatabase.setAdditionalInformation(testPattern.getAdditionalInformation());
		Date date = new Date();
		testPatternToDatabase.setCreatedDate(date);
		testPatternToDatabase.setGradingMethod(testPattern.getGradingMethod());
		testPatternToDatabase.setIsSingleChoice(testPattern.isSingleChoice());
		testPatternRepo.save(testPatternToDatabase);
		List<CategoryViewAll> categories = testPattern.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			CategoryUsedInTestPattern categoryUsed = new CategoryUsedInTestPattern();
			categoryUsed.setTestPattern(testPatternToDatabase);
			categoryUsed.setCategory(categoryRepo.findOne(categories.get(i).getId()));
			categoryUsed.setNumberOfQuestions(categories.get(i).getQuestionCount());
			cuitpRepo.save(categoryUsed);
		}
		testPattern.setId(testPatternToDatabase.getId());
		return testPattern;
	}
	
}
