package com.bubble.hearthstone.util.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import com.bubble.hearthstone.util.resource.ResourceLoader;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class ConfigLoader extends ResourceLoader<Config> {

    public ConfigLoader(Config resourceConfig) {
        super(resourceConfig);
    }

    protected String getKey() {
        return "config";
    }

    protected Config loadResource(String path) {
        final Properties properties;
        try(Reader reader = new FileReader(new File(path))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            ServiceLocator.getLogger().error(this, e);
            return null;
        }
        return new Config(properties);
    }

    public static Config get(String path) {
        return new ConfigLoader(null).loadResource(findPath(path));
    }
}
