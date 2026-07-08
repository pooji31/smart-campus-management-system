package com.scms.service;

import com.scms.dao.StudentDAO;
import com.scms.model.Student;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public boolean saveStudent(Student student) {

        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        if (student.getStudentName() == null ||
                student.getStudentName().isBlank())
            throw new IllegalArgumentException("Student Name Required");

        if (student.getEmail() == null ||
                student.getEmail().isBlank())
            throw new IllegalArgumentException("Email Required");

        return studentDAO.save(student);

    }

}