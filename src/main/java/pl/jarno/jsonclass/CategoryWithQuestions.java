package pl.jarno.jsonclass;

import java.util.List;

import pl.jarno.entity.Category;
import pl.jarno.entity.Question;

public class CategoryWithQuestions {
	
	private Category category;
	private List<Question> questions;
	
	public CategoryWithQuestions() {
		
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> list) {
		this.questions = list;
	}
	

}
