package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties properties;

    public static Properties loadApplicationProperties() {
        properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/test/resources/config/dev.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
