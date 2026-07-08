package com.scms.model;

import java.util.Objects;

public class Marks {

	private int markId;
	private Student student;
	private Subject subject;
	private double internalMarks;
	private double externalMarks;
	private double total;
	private String grade;
	
	public Marks() {
	}

	public Marks(int markId, Student student, Subject subject, double internalMarks, double externalMarks, double total,
			String grade) {
		super();
		this.markId = markId;
		this.student = student;
		this.subject = subject;
		this.internalMarks = internalMarks;
		this.externalMarks = externalMarks;
		this.total = total;
		this.grade = grade;
	}

	public int getMarkId() {
		return markId;
	}

	public void setMarkId(int markId) {
		this.markId = markId;
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

	public double getInternalMarks() {
		return internalMarks;
	}

	public void setInternalMarks(double internalMarks) {
		this.internalMarks = internalMarks;
	}

	public double getExternalMarks() {
		return externalMarks;
	}

	public void setExternalMarks(double externalMarks) {
		this.externalMarks = externalMarks;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Marks [markId=" + markId + ", student=" + student + ", subject=" + subject + ", internalMarks="
				+ internalMarks + ", externalMarks=" + externalMarks + ", total=" + total + ", grade=" + grade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(externalMarks, grade, internalMarks, markId, student, subject, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marks other = (Marks) obj;
		return Double.doubleToLongBits(externalMarks) == Double.doubleToLongBits(other.externalMarks)
				&& Objects.equals(grade, other.grade)
				&& Double.doubleToLongBits(internalMarks) == Double.doubleToLongBits(other.internalMarks)
				&& markId == other.markId && Objects.equals(student, other.student)
				&& Objects.equals(subject, other.subject)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}
	
}
