package com.bubble.hearthstone.util.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import com.bubble.hearthstone.util.resource.ResourceLoader;

public class ConfigLoader extends ResourceLoader<Properties> {

    public Properties loadFile(String path) {
        final Properties properties;
        try(Reader reader = new FileReader(new File(path))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            // error
            return null;
        }
        return properties;
    }
}
