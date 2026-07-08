package com.scms.test;

import java.sql.Connection;
import java.util.logging.Logger;

import com.scms.util.DatabaseConnection;

public class DatabaseConnectionTest {

    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();

        if(connection != null){
        	Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
        	logger.info("Database Connected");

        }

    }

}