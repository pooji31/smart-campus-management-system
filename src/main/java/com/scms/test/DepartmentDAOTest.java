package com.scms.test;

import java.util.List;

import com.scms.dao.DepartmentDAO;
import com.scms.model.Department;

public class DepartmentDAOTest {

    public static void main(String[] args) {
//
//        Department department = new Department();
//
//        department.setDepartmentName("Computer Science");
//
//        department.setDepartmentCode("CSE");
//
//        DepartmentDAO dao = new DepartmentDAO();
//
//        boolean saved = dao.save(department);
//
//        System.out.println(saved);
//
//    }
    
		DepartmentDAO dao = new DepartmentDAO();
//
//		List<Department> departments = dao.findAll();
//
//		for (Department department : departments) {
//			System.out.println(department);
//		}

//		Department department = dao.findById(2);
//		System.out.println(department);
		
		Department department = dao.findById(1);
		department.setDepartmentName("Computer Engineering");
		boolean updated = dao.update(department);
		System.out.println(updated);
		
		boolean deleted = dao.delete(3);
		System.out.println(deleted);
	}
}