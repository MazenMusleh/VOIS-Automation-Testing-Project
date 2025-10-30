package Utilization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    private final Properties properties;
    private final String filePath;


    public PropertyFileReader(String filePath) {
        this.filePath = filePath;
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file from path: " + filePath, e);
        }
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }


    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            properties.store(fos, "Updated test data");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to properties file: " + filePath, e);
        }
    }
}
