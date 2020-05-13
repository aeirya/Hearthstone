package com.bubble.hearthstone.util.config;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.bubble.hearthstone.util.file.FileLoader;
import com.bubble.hearthstone.util.file.IFileReader;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class ConfigLoader implements IFileReader<Config> {

    private static final ConfigLoader instance = new ConfigLoader();

    private static ConfigLoader getInstance() {
        return instance;
    }

    /** loads the config at path */
    public static Config get(String path) {
        return getInstance().load(
            getPath(path)
        );
    }

    private static String getPath(String path) {
        String inClasspath = getFileInClassPath(path);
        if (new File(inClasspath).exists()) return inClasspath;
        return path; 
    }

    private static String getFileInClassPath(String path) {
        return ConfigLoader.class.getClassLoader().getResource(path).getFile();
        //gotta change this
    }

    public Config load(String path) {
        final FileLoader loader = new FileLoader(path);
        final Properties properties = new Properties();
        try {
            properties.load(loader.getReader());
        } catch (IOException e) {
            ServiceLocator.getLogger().error(this, e);
        }
        return (Config) properties; //TODO: fix config mechanism
    }

    //TODO: integrate IFileReader interface and ResourceLoader
}
