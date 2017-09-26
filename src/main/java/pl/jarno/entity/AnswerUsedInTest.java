package pl.jarno.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "answers_used_in_tests")
public class AnswerUsedInTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	private boolean isCorrect;
	@ManyToOne
	private QuestionUsedInTest questionUsedInTest;
	
	public AnswerUsedInTest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public QuestionUsedInTest getQuestionUsedInTest() {
		return questionUsedInTest;
	}

	public void setQuestionUsedInTest(QuestionUsedInTest questionUsedInTest) {
		this.questionUsedInTest = questionUsedInTest;
	}
	
	

}
