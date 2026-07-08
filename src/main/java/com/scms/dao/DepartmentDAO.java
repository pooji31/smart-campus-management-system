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

	    String sql =
	            "INSERT INTO departments(department_name,department_code) VALUES(?,?)";

	    try (

	            Connection connection =
	                    DatabaseConnection.getConnection();

	            PreparedStatement ps =
	                    connection.prepareStatement(sql);

	    ) {

	        ps.setString(1,
	                department.getDepartmentName());

	        ps.setString(2,
	                department.getDepartmentCode());

	        int rows =
	                ps.executeUpdate();

	        return rows > 0;

	    }

	    catch (Exception e) {

	        e.printStackTrace();

	    }

	    return false;

	}
	
	public boolean existsByCode(String code) {

	    String sql =
	            "SELECT * FROM departments WHERE department_code=?";

	    try (

	            Connection connection =
	                    DatabaseConnection.getConnection();

	            PreparedStatement ps =
	                    connection.prepareStatement(sql);

	    ) {

	        ps.setString(1, code);

	        ResultSet rs =
	                ps.executeQuery();

	        return rs.next();

	    }

	    catch (Exception e) {

	        e.printStackTrace();

	    }

	    return false;

	}
	
	public Department findById(int id) {

	    String sql =
	            "SELECT * FROM departments WHERE department_id=?";

	    try (

	            Connection connection =
	                    DatabaseConnection.getConnection();

	            PreparedStatement ps =
	                    connection.prepareStatement(sql);

	    ) {

	        ps.setInt(1, id);

	        ResultSet rs =
	                ps.executeQuery();

	        if (rs.next()) {

	            Department department =
	                    new Department();

	            department.setDepartmentId(
	                    rs.getInt("department_id"));

	            department.setDepartmentName(
	                    rs.getString("department_name"));

	            department.setDepartmentCode(
	                    rs.getString("department_code"));

	            return department;

	        }

	    }

	    catch (Exception e) {

	        e.printStackTrace();

	    }

	    return null;

	}
	
	public List<Department> findAll() {

	    List<Department> departments = new ArrayList<>();

	    String sql = "SELECT * FROM departments ORDER BY department_name";

	    try (
	            Connection connection = DatabaseConnection.getConnection();

	            PreparedStatement ps = connection.prepareStatement(sql);

	            ResultSet rs = ps.executeQuery();
	    ) {

	        while (rs.next()) {

	            Department department = new Department();

	            department.setDepartmentId(rs.getInt("department_id"));

	            department.setDepartmentName(rs.getString("department_name"));

	            department.setDepartmentCode(rs.getString("department_code"));

	            departments.add(department);

	        }

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return departments;

	}
	
	public boolean update(Department department) {

	    String sql = """
	            UPDATE departments
	            SET department_name=?,
	                department_code=?
	            WHERE department_id=?
	            """;

	    try (
	            Connection connection = DatabaseConnection.getConnection();

	            PreparedStatement ps = connection.prepareStatement(sql);
	    ) {

	        ps.setString(1, department.getDepartmentName());

	        ps.setString(2, department.getDepartmentCode());

	        ps.setInt(3, department.getDepartmentId());

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return false;

	}
	
	public boolean delete(int departmentId) {

	    String sql = """
	            DELETE FROM departments
	            WHERE department_id=?
	            """;

	    try (
	            Connection connection = DatabaseConnection.getConnection();

	            PreparedStatement ps = connection.prepareStatement(sql);
	    ) {

	        ps.setInt(1, departmentId);

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return false;

	}
	
	
}
