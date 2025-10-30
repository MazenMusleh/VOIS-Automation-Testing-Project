package Utilization;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static ConfigManager instance;
    private final Map<String, PropertyFileReader> readers = new HashMap<>();

    private ConfigManager() {}

    public static void init(String alias, String filePath) {
        if (instance == null) {
            instance = new ConfigManager();
        }
        instance.readers.put(alias, new PropertyFileReader(filePath));
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ConfigManager not initialized. Call init(alias, filePath) first.");
        }
        return instance;
    }

    public String getProperty(String alias, String key) {
        PropertyFileReader reader = readers.get(alias);
        if (reader == null) {
            throw new IllegalArgumentException("No property file registered with alias: " + alias);
        }
        return reader.getProperty(key);
    }
}
