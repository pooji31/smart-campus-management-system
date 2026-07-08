package com.scms.model;

import java.util.Objects;

public class Course {

	private int courseId;
	private String courseName;
	private int duration;
	private Department department;
	
	public Course() {
	}

	public Course(int courseId, String courseName, int duration, Department department) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.department = department;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration
				+ ", department=" + department + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, department, duration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseId == other.courseId && Objects.equals(courseName, other.courseName)
				&& Objects.equals(department, other.department) && duration == other.duration;
	}
	
}
