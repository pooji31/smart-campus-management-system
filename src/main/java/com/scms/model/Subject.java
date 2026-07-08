package com.scms.model;

import java.util.Objects;

public class Subject {

	private int subjectId;
	private String subjectName;
	private String subjectCode;

	private Faculty faculty;
	private Course course;

	private int semester;
	private int credits;
	
	public Subject() {
	}

	public Subject(int subjectId, String subjectName, String subjectCode, Faculty faculty, Course course, int semester,
			int credits) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.faculty = faculty;
		this.course = course;
		this.semester = semester;
		this.credits = credits;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode
				+ ", faculty=" + faculty + ", course=" + course + ", semester=" + semester + ", credits=" + credits
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, credits, faculty, semester, subjectCode, subjectId, subjectName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(course, other.course) && credits == other.credits
				&& Objects.equals(faculty, other.faculty) && semester == other.semester
				&& Objects.equals(subjectCode, other.subjectCode) && subjectId == other.subjectId
				&& Objects.equals(subjectName, other.subjectName);
	}
	
}
