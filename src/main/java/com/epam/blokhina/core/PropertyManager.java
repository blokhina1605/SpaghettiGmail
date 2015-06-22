package com.epam.blokhina.core;

import com.epam.blokhina.core.exceptions.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class PropertyManager {
    public static Properties properties;

    private static final String FILE_PATH = "src\\main\\resources\\config.properties";

    public static void loadProperties() {
        properties = new Properties();

        try (InputStream inputStream = Files.newInputStream(Paths.get(".").resolve(FILE_PATH))) {
            properties.load(inputStream);
            setProperties(properties);
        } catch (IOException e) {
            throw new ConfigurationException("Something was wrong in " + FILE_PATH);
        }
    }

    public static String getPropertyByName(String propertyName) {
        loadProperties();
        return properties.getProperty(propertyName);
    }

    public static void setProperties(Properties properties) {
        PropertyManager.properties = properties;
    }
}
