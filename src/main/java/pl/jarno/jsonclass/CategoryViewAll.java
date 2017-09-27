package pl.jarno.jsonclass;

import pl.jarno.jsonclass.superior.CategoryJson;

public class CategoryViewAll extends CategoryJson {
	
	private int questionCount;
	
	
	CategoryViewAll (Long id, String name, int questionCount) {
		super(id, name);
		this.questionCount = questionCount;
	}


	public int getQuestionCount() {
		return questionCount;
	}


	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	

}
