package com.apps.flipkart.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConfigManager {

    private static final String TEST_CONFIG_FILE ;
    private static final Logger LOGGER;
    private static Map<String, String> configMap;

    private ConfigManager() {
    }

    static {
        TEST_CONFIG_FILE = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "properties", "config.properties").toString();
        LOGGER = LoggerFactory.getLogger(ConfigManager.class);
        configMap = new HashMap();
    }

    public static synchronized String getConfigProperty(String key) {
        if (configMap.size() == 0) {
            Properties properties = new Properties();

            try {
                properties.load(new FileInputStream(TEST_CONFIG_FILE));
                configMap = new HashMap((Map)properties.entrySet().stream().collect(Collectors.toMap((e) -> {
                    return e.getKey().toString();
                }, (e) -> {
                    return e.getValue().toString();
                })));
                LOGGER.debug("Loaded config properties : " + TEST_CONFIG_FILE);
            } catch (Exception exception) {
                LOGGER.error(exception.getMessage());
                throw new RuntimeException(exception);
            }
        }
        return (String)configMap.get(key);
    }

    public static String getBrowser() {
        return (!System.getProperty("browser").isEmpty() ? System.getProperty("browser") : getConfigProperty("browser")).toUpperCase();
    }
}
