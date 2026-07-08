package com.scms.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final Properties properties = new Properties();

    static {

        try (InputStream input = PropertyLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}