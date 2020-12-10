package com.bed2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssessmentResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String date;
	String assessmentName;
	int marks;
	String email;
	int totalMarks = 50;
	String result;
	
	public AssessmentResult() {
		super();
	}

	public AssessmentResult(String date, String assessmentName, int marks, String email, String result) {
		super();
		this.date = date;
		this.assessmentName = assessmentName;
		this.marks = marks;
		this.email = email;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "AssessmentResult [id=" + id + ", date=" + date + ", assessmentName=" + assessmentName + ", marks="
				+ marks + ", email=" + email + ", totalMarks=" + totalMarks + ", result=" + result + "]";
	}
	
}
