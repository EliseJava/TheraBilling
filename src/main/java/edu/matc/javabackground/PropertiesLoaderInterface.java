package edu.matc.javabackground;

import java.io.*;
import java.util.*;

/**
 * This interfaces function loads the properties file and returns a property Map
 *
 * @author Elise Strauss
 * interface PropertiesLoaderInterface
 */
public interface PropertiesLoaderInterface {

    /**
     * @param propertiesFilePath the properties file
     * @return properties The properties Map
     */
    default Properties loadProperties(String propertiesFilePath) {

        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException inputOutputException) {
            inputOutputException.printStackTrace();
            return null;
        } catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return properties;
    }
}