package com.scms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.scms.config.DatabaseConnection;
import com.scms.model.Role;

public class RoleDAO {

    public Role findById(int roleId) {

        String sql =
        "SELECT * FROM roles WHERE role_id=?";

        try(

        Connection connection =
        DatabaseConnection.getConnection();

        PreparedStatement ps =
        connection.prepareStatement(sql);

        ){

            ps.setInt(1, roleId);

            ResultSet rs =
            ps.executeQuery();

            if(rs.next()){

                Role role =
                new Role();

                role.setRoleId(
                rs.getInt("role_id"));

                role.setRoleName(
                rs.getString("role_name"));

                return role;

            }

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return null;

    }

}