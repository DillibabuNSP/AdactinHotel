package org.atmecs.web_automation_adactin.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains methods for reading properties files.
 *
 * 
 */
public class PropertyParser {

    private Properties properties;

    /**
     * This is constructor
     *
     * @param propertyFilePath
     */
    public PropertyParser(String propertyFilePath) {
        properties = new Properties();
        loadProperties(propertyFilePath);
    }

    // This is Private Constructor
    private PropertyParser() {
    }

    /**
     * This method loads properties file.
     *
     * @param propertyFilePath
     */
    private void loadProperties(String propertyFilePath) {
    	try (FileInputStream fileInputStream = new FileInputStream(propertyFilePath)) {
    	    properties.load(fileInputStream);
    	} catch (IOException ioException) {
    	    ioException.printStackTrace();
    	}

    }

    /**
     * This method returns value from the properties file base on
     * given key.
     *
     * @param key
     * @return
     */
    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
