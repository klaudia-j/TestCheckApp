package pl.jarno.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	@Column(name = "is_correct")
	private boolean isCorrect;
//	@JsonIgnore
//	@ManyToOne
//	private Question question;
	
	public Answer() {
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
	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
//	public Question getQuestion() {
//		return question;
//	}
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
	
	
	
}
