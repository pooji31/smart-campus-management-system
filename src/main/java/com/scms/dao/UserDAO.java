package com.scms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.scms.model.Role;
import com.scms.model.User;
import com.scms.util.DatabaseConnection;

public class UserDAO {
	RoleDAO roleDAO = new RoleDAO();
	public boolean save(User user) {

	    String sql =
	    "INSERT INTO users(username,password,email,role_id) VALUES(?,?,?,?)";

	    try (

	        Connection connection =
	                DatabaseConnection.getConnection();

	        PreparedStatement ps =
	                connection.prepareStatement(sql);

	    ) {

	        ps.setString(1, user.getUsername());

	        ps.setString(2, user.getPassword());

	        ps.setString(3, user.getEmail());

	        ps.setInt(4,
	                user.getRole().getRoleId());

	        int rows =
	                ps.executeUpdate();

	        return rows > 0;

	    }

	    catch (Exception e) {

	        e.printStackTrace();

	    }

	    return false;

	}
	
	public User findByUsername(String username) {

	    String sql =
	    "SELECT * FROM users WHERE username=?";

	    try (

	        Connection connection =
	                DatabaseConnection.getConnection();

	        PreparedStatement ps =
	                connection.prepareStatement(sql);

	    ) {

	        ps.setString(1, username);

	        ResultSet rs =
	                ps.executeQuery();

	        if (rs.next()) {

	            User user =
	                    new User();

	            user.setUserId(
	                    rs.getInt("user_id"));

	            user.setUsername(
	                    rs.getString("username"));

	            user.setPassword(
	                    rs.getString("password"));

	            user.setEmail(
	                    rs.getString("email"));

	            Role role =
	                    roleDAO.findById(
	                            rs.getInt("role_id"));

	            user.setRole(role);

	            return user;

	        }

	    }

	    catch (Exception e) {

	        e.printStackTrace();

	    }

	    return null;

	}
	
	public boolean existsByUsername(String username) {

	    return findByUsername(username) != null;

	}
	
	public boolean existsByEmail(String email){

	    return findByEmail(email)!=null;

	}

	public User findByEmail(String email) {

	    String sql = "SELECT * FROM users WHERE email=?";

	    try (

	        Connection connection = DatabaseConnection.getConnection();

	        PreparedStatement ps = connection.prepareStatement(sql);

	    ) {

	        ps.setString(1, email);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            User user = new User();

	            user.setUserId(rs.getInt("user_id"));

	            user.setUsername(rs.getString("username"));

	            user.setPassword(rs.getString("password"));

	            user.setEmail(rs.getString("email"));

	            Role role = new Role();

	            role.setRoleId(rs.getInt("role_id"));

	            user.setRole(role);

	            return user;

	        }

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return null;
	}
	
	
}
