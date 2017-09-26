package pl.jarno.jsonclass;

import pl.jarno.entity.Question;

import java.util.ArrayList;
import java.util.List;

import pl.jarno.entity.Answer;

public class QuestionWithAnswers {
	
	private Question question;
	private List<Answer> answers = new ArrayList<>();
	
	QuestionWithAnswers() {
		
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	

}

//public class QuestionWithAnswers {
//	
//	private String questionContent;
//	private Long questionId;
//	private List<AnswerInJson> answers = new ArrayList<>();
//	
//	QuestionWithAnswers() {
//		
//	}
//
//
//	public String getQuestionContent() {
//		return questionContent;
//	}
//
//
//	public void setQuestionContent(String questionContent) {
//		this.questionContent = questionContent;
//	}
//
//
//	public List<AnswerInJson> getAnswers() {
//		return answers;
//	}
//
//	public void setAnswers(List<AnswerInJson> answers) {
//		this.answers = answers;
//	}
//
//
//	public Long getQuestionId() {
//		return questionId;
//	}
//
//
//	public void setQuestionId(Long questionId) {
//		this.questionId = questionId;
//	}
