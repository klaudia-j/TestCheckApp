package pl.jarno.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "categories_used_in_test_patterns")
public class CategoryUsedInTestPattern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private TestPattern testPattern;
	@ManyToOne
	private Category category;
	private int numberOfQuestions;
	
	public CategoryUsedInTestPattern () {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TestPattern getTestPattern() {
		return testPattern;
	}
	public void setTestPattern(TestPattern testPattern) {
		this.testPattern = testPattern;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	
	

}

