package com.scms.model;

import java.util.Objects;

public class Enrollment {

	private int enrollmentId;
	private Student student;
	private Subject subject;
	private int semester;
	private String academicYear;
	
	public Enrollment() {
	}

	public Enrollment(int enrollmentId, Student student, Subject subject, int semester, String academicYear) {
		super();
		this.enrollmentId = enrollmentId;
		this.student = student;
		this.subject = subject;
		this.semester = semester;
		this.academicYear = academicYear;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", student=" + student + ", subject=" + subject
				+ ", semester=" + semester + ", academicYear=" + academicYear + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(academicYear, enrollmentId, semester, student, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollment other = (Enrollment) obj;
		return Objects.equals(academicYear, other.academicYear) && enrollmentId == other.enrollmentId
				&& semester == other.semester && Objects.equals(student, other.student)
				&& Objects.equals(subject, other.subject);
	}
	
}
