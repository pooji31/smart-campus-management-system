package com.scms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.scms.model.Student;
import com.scms.util.DatabaseConnection;

public class StudentDAO {

    public boolean save(Student student) {

        String sql = "INSERT INTO students(student_name,email,phone,gender,dob,address,department_id) VALUES(?,?,?,?,?,?,?)";

        try (
                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement ps = connection.prepareStatement(sql);

        ) {

            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getGender());

            ps.setDate(5, Date.valueOf(student.getDob()));

            ps.setString(6, student.getAddress());

            ps.setInt(7, student.getDepartmentId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

}