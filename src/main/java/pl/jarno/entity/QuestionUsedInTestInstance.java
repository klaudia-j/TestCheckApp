package pl.jarno.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "questions_used_in_test_instances")
public class QuestionUsedInTestInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private TestInstance testInstance;
	@ManyToOne
	private QuestionUsedInTest questionUsedInTest;
	private Long[] answerOrder = new Long[6];
	private boolean[] answerIsChecked = new boolean[6];
	
	public QuestionUsedInTestInstance() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TestInstance getTestInstance() {
		return testInstance;
	}

	public void setTestInstance(TestInstance testInstance) {
		this.testInstance = testInstance;
	}

	public QuestionUsedInTest getQuestionUsedInTest() {
		return questionUsedInTest;
	}

	public void setQuestionUsedInTest(QuestionUsedInTest questionUsedInTest) {
		this.questionUsedInTest = questionUsedInTest;
	}

	public Long[] getAnswerOrder() {
		return answerOrder;
	}

	public void setAnswerOrder(Long[] answerOrder) {
		this.answerOrder = answerOrder;
	}

	public boolean[] getAnswerIsChecked() {
		return answerIsChecked;
	}

	public void setAnswerIsChecked(boolean[] answerIsChecked) {
		this.answerIsChecked = answerIsChecked;
	}
	
	
	
}
