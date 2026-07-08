package com.scms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scms.model.Department;
import com.scms.util.DatabaseConnection;

public class DepartmentDAO {

	public boolean save(Department department) {
		String sql = "INSERT INTO departments(department_name, department_code) VALUES (?, ?)";
		try (
				Connection connection = DatabaseConnection.getConnection();
		
		        PreparedStatement ps = connection.prepareStatement(sql);
		){
			ps.setString(1, department.getDepartmentName());
			
			ps.setString(2, department.getDepartmentCode());
			
			int rows = ps.executeUpdate();
			
			return rows>0;
		}
		
		catch (SQLException e) {
			 throw new DuplicateDepartmentException("Department code already exists.");
	    }
	}
	
	public List<Department> findAll() {
	    String sql = "SELECT department_id, department_name, department_code FROM departments";
	    List<Department> departments = new ArrayList<>();
	    try (
	            Connection connection = DatabaseConnection.getConnection();

	            PreparedStatement ps = connection.prepareStatement(sql);

	            ResultSet rs = ps.executeQuery()
	    ) {

	        while (rs.next()) {

	            Department department = new Department();

	            department.setDepartmentId(rs.getInt("department_id"));

	            department.setDepartmentName(rs.getString("department_name"));

	            department.setDepartmentCode(rs.getString("department_code"));

	            departments.add(department);

	        }

	    }

	    catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return departments;

	}
	
	public Department findById(int departmentId) {

	    String sql = "SELECT department_id, department_name, department_code FROM departments WHERE department_id=?";

	    try (
	            Connection connection = DatabaseConnection.getConnection();

	            PreparedStatement ps = connection.prepareStatement(sql)

	    ) {

	        ps.setInt(1, departmentId);

	        try (ResultSet rs = ps.executeQuery()) {

	            if (rs.next()) {

	                Department department = new Department();

	                department.setDepartmentId(rs.getInt("department_id"));

	                department.setDepartmentName(rs.getString("department_name"));

	                department.setDepartmentCode(rs.getString("department_code"));

	                return department;
	            }

	        }

	    }

	    catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;

	}
	
	public boolean update(Department department) {

	    String sql = "UPDATE departments SET department_name=?, department_code=? WHERE department_id=?";

	    try (

	        Connection connection = DatabaseConnection.getConnection();

	        PreparedStatement ps = connection.prepareStatement(sql)

	    ) {

	        ps.setString(1, department.getDepartmentName());

	        ps.setString(2, department.getDepartmentCode());

	        ps.setInt(3, department.getDepartmentId());

	        int rows = ps.executeUpdate();

	        return rows > 0;

	    }

	    catch(SQLException e){
	        e.printStackTrace();
	    }

	    return false;

	}
	
	public boolean delete(int departmentId) {

	    String sql = "DELETE FROM departments WHERE department_id=?";

	    try (

	        Connection connection = DatabaseConnection.getConnection();

	        PreparedStatement ps = connection.prepareStatement(sql)

	    ) {

	        ps.setInt(1, departmentId);

	        int rows = ps.executeUpdate();

	        return rows > 0;

	    }

	    catch(SQLException e){
	        e.printStackTrace();
	    }

	    return false;

	}
	
	
}
