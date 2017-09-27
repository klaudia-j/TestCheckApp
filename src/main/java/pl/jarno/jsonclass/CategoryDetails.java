package pl.jarno.jsonclass;

import java.util.List;

import pl.jarno.entity.Question;
import pl.jarno.jsonclass.superior.CategoryJson;

public class CategoryDetails extends CategoryJson {
	
	private List<Question> questions;
	
	public CategoryDetails() {
		
	}
	
	public CategoryDetails (Long id, String name, List<Question> questions) {
		super(id, name);
		this.questions = questions;
	}

	public List <Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> list) {
		this.questions = list;
	}
	
	
	
}
