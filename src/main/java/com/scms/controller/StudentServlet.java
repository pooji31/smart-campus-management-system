package com.scms.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.scms.model.Student;
import com.scms.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/students/register")
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Student student = new Student();

        student.setStudentName(
                request.getParameter("studentName"));

        student.setEmail(
                request.getParameter("email"));

        student.setPhone(
                request.getParameter("phone"));

        student.setGender(
                request.getParameter("gender"));

        student.setDob(
                LocalDate.parse(request.getParameter("dob")));

        student.setAddress(
                request.getParameter("address"));

        student.setDepartmentId(
                Integer.parseInt(
                        request.getParameter("departmentId")));

        boolean status =
                studentService.saveStudent(student);

        if (status) {

            response.sendRedirect("success.html");

        } else {

            response.sendRedirect("error.html");

        }

    }

}