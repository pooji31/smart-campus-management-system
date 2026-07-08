package com.scms.service;

import com.scms.dao.DepartmentDAO;
import com.scms.model.Department;

public class DepartmentService {

    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public boolean saveDepartment(Department department){

        if(department==null){

            throw new IllegalArgumentException("Department cannot be null");

        }

        if(department.getDepartmentName()==null
                || department.getDepartmentName().isBlank()){

            throw new IllegalArgumentException(
                    "Department name is required");

        }

        if(department.getDepartmentCode()==null
                || department.getDepartmentCode().isBlank()){

            throw new IllegalArgumentException(
                    "Department code is required");

        }

        department.setDepartmentCode(department.getDepartmentCode().toUpperCase()

        );

        return departmentDAO.save(department);

    }

}