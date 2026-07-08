package com.scms.model;

import java.util.Objects;

public class Faculty {

	private int facultyId;
	private User user;
	private Department department;

	private String facultyName;
	private String designation;
	private String phone;
	
	public Faculty() {
	}

	public Faculty(int facultyId, User user, Department department, String facultyName, String designation,
			String phone) {
		super();
		this.facultyId = facultyId;
		this.user = user;
		this.department = department;
		this.facultyName = facultyName;
		this.designation = designation;
		this.phone = phone;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", user=" + user + ", department=" + department + ", facultyName="
				+ facultyName + ", designation=" + designation + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, designation, facultyId, facultyName, phone, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(department, other.department) && Objects.equals(designation, other.designation)
				&& facultyId == other.facultyId && Objects.equals(facultyName, other.facultyName)
				&& Objects.equals(phone, other.phone) && Objects.equals(user, other.user);
	}
	
}
