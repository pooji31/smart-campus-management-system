package com.scms.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private static final String PROPERTY_FILE = "db.properties";

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {

        try {

            Properties properties = new Properties();

            InputStream inputStream =
                    DatabaseConnection.class
                    .getClassLoader()
                    .getResourceAsStream(PROPERTY_FILE);

            properties.load(inputStream);

            driver = properties.getProperty("db.driver");
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");

            Class.forName(driver);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to load database configuration", e);

        }

    }

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    url,
                    username,
                    password);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}