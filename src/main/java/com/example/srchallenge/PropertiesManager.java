package com.example.srchallenge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesManager {
    Properties props;
    String propertiesPath;

    public PropertiesManager(String pathStr) throws Exception {
        this.propertiesPath = pathStr;
        props = new Properties();
        if (Files.exists(Paths.get(propertiesPath))) {
            props.load(new FileInputStream(propertiesPath));
        } else {
            replace("City", "Maribor");
        }
    }

    public Object get(String key) {
        if (Files.exists(Paths.get(propertiesPath))) {
            return props.get(key);
        }
        return null;
    }

    public void replace(String key, String value) {
        props.put(key, value);
        try (FileOutputStream outputStream = new FileOutputStream(propertiesPath)) {
            props.store(outputStream, "Saved user manually input location");
        } catch (IOException e) {
            System.err.println("Error occurred while writing to properties file: " + e.getMessage());
        }
    }
}