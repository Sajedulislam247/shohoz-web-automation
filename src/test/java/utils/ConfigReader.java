package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/testdata.properties";
            FileInputStream inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
