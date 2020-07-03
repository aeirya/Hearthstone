package com.bubble.hearthstone.util.config;

import java.util.Properties;

public class Config {
    
    protected final Properties config;

    public Config(String path) {
        this.config = findConfig(path);
    }

    private Properties findConfig(String path) { 
        return new ConfigLoader().loadFile(path);
    }
}