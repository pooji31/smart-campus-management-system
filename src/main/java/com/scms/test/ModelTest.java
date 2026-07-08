package com.scms.test;

import com.scms.model.Course;
import com.scms.model.Department;

public class ModelTest {
public static void main(String[] args) {
	Department department = new Department();
	department.setDepartmentId(1);
	department.setDepartmentName("Computer Science");
	department.setDepartmentCode("CSE");

	Course course = new Course();
	course.setCourseId(1);
	course.setCourseName("B.Tech");
	course.setDepartment(department);

	System.out.println(course);
}
}
