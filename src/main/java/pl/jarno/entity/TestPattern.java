package pl.jarno.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_patterns")
public class TestPattern {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String title;
		private String teacherName;
		private boolean isNameRequired;
		private boolean isIdRequired;
		private String additionalInformation;
		private int gradingMethod;
		private Date createdDate;
		private boolean isSingleChoice;
		@ManyToOne
		private User user;
		
		public TestPattern() {
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
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
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
		
		
		
		
}
