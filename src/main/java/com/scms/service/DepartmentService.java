package com.scms.service;

import java.util.List;

import com.scms.dao.DepartmentDAO;
import com.scms.model.Department;
import com.scms.util.ValidationUtil;

public class DepartmentService {

    private DepartmentDAO dao = new DepartmentDAO();
    
    public boolean addDepartment(Department department) {

        if (department == null) {
            throw new IllegalArgumentException(
                    "Department cannot be null");
        }

        if (ValidationUtil.isNullOrEmpty(
                department.getDepartmentName())) {

            throw new IllegalArgumentException(
                    "Department name is required");
        }

        if (ValidationUtil.isNullOrEmpty(
                department.getDepartmentCode())) {

            throw new IllegalArgumentException(
                    "Department code is required");
        }

        if (dao.existsByCode(
                department.getDepartmentCode())) {

            throw new IllegalArgumentException(
                    "Department code already exists");
        }

        return dao.save(department);

    }
    
    public List<Department> getAllDepartments() {

        return dao.findAll();

    }
    
    public Department getDepartmentById(int id) {

        if (id <= 0) {

            throw new IllegalArgumentException(
                    "Invalid Department Id");

        }

        return dao.findById(id);

    }
    
    public boolean updateDepartment(
            Department department) {

        if (department == null) {

            throw new IllegalArgumentException(
                    "Department is null");

        }

        if (department.getDepartmentId() <= 0) {

            throw new IllegalArgumentException(
                    "Invalid Department Id");

        }

        if (ValidationUtil.isNullOrEmpty(
                department.getDepartmentName())) {

            throw new IllegalArgumentException(
                    "Department name required");

        }

        if (ValidationUtil.isNullOrEmpty(
                department.getDepartmentCode())) {

            throw new IllegalArgumentException(
                    "Department code required");

        }

        return dao.update(department);

    }
    
    public boolean deleteDepartment(int id) {

        if (id <= 0) {

            throw new IllegalArgumentException(
                    "Invalid Department Id");

        }

        return dao.delete(id);

    }
    
    

}