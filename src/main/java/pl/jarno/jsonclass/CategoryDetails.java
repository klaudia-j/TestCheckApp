package pl.jarno.jsonclass;

import pl.jarno.jsonclass.superior.CategoryJson;

public class CategoryDetails extends CategoryJson {
	
	private QuestionWithAnswers questions;
	
	public CategoryDetails() {
		
	}
	
	public CategoryDetails (Long id, String name, QuestionWithAnswers questions) {
		super(id, name);
		this.questions = questions;
	}

	public QuestionWithAnswers getQuestions() {
		return questions;
	}

	public void setQuestions(QuestionWithAnswers questions) {
		this.questions = questions;
	}
	
	
	
}
