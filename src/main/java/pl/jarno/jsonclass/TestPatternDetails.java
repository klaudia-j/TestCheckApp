package pl.jarno.jsonclass;

import java.util.Date;
import java.util.List;

public class TestPatternDetails extends TestPatternJson {
	
	private String teacherName;
	private boolean isNameRequired;
	private boolean isIdRequired;
	private String additionalInformation;
	private int gradingMethod;
	private Date createdDate;
	private boolean isSingleChoice;
	private List<CategoryViewAll> categories;
	
	public TestPatternDetails() {
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

	public void setIsNameRequired(boolean isNameRequired) {
		this.isNameRequired = isNameRequired;
	}

	public boolean isIdRequired() {
		return isIdRequired;
	}

	public void setIsIdRequired(boolean isIdRequired) {
		this.isIdRequired = isIdRequired;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public int getGradingMethod() {
		return gradingMethod;
	}

	public void setGradingMethod(int gradingMethod) {
		this.gradingMethod = gradingMethod;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isSingleChoice() {
		return isSingleChoice;
	}

	public void setIsSingleChoice(boolean isSingleChoice) {
		this.isSingleChoice = isSingleChoice;
	}

	public List<CategoryViewAll> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryViewAll> categories) {
		this.categories = categories;
	}
	
	

}
