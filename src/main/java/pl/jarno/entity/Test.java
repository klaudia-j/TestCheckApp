package pl.jarno.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tests")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int numberOfQuestions;
	private String teacherName;
	private boolean isNameRequired;
	private boolean isIdRquired;
	private boolean additionalInformation;
	private int gradingMethod;
	@ManyToOne
	private User user;
	private Date createdDate;
	private boolean isSingleChoice;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isSingleChoice() {
		return isSingleChoice;
	}

	public void setSingleChoice(boolean isSingleChoice) {
		this.isSingleChoice = isSingleChoice;
	}

	public Test() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public boolean isNameRequired() {
		return isNameRequired;
	}
	public void setNameRequired(boolean isNameRequired) {
		this.isNameRequired = isNameRequired;
	}
	public boolean isIdRquired() {
		return isIdRquired;
	}
	public void setIdRquired(boolean isIdRquired) {
		this.isIdRquired = isIdRquired;
	}
	public boolean isAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(boolean additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public int getGradingMethod() {
		return gradingMethod;
	}
	public void setGradingMethod(int gradingMethod) {
		this.gradingMethod = gradingMethod;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	
	
	

}
