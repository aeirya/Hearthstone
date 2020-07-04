package com.bubble.hearthstone.util.config;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceConfig extends Config {
    
    private static final String DATA_PATH = "data/";
    
    public ResourceConfig(String path) {
        super(path);
    }

    public String get(ResourceType type) {
        final String key = parse(type);
        return DATA_PATH + config.getProperty(key);
    }

    private String parse(ResourceType type) {
        switch(type) {
            case IMAGE:
            return "image";
            case SETTING:
            return "settings";
            case USER:
            return "user";
            default:
            return "";
        }
    } 

    public String getImagesFolder() {
        return get(ResourceType.IMAGE);
    }

    public String getCardsFolder() {
        return get(ResourceType.CARD);
    }

    public String getSettingsFolder() {
        return get(ResourceType.SETTING);
    }

    public String getUsersFolder() {
        return get(ResourceType.USER);
    }

    public List<String> getAll() {
        return config
            .values()
            .stream()
            .map(obj -> (String) obj)
            .map(value -> DATA_PATH + value)
            .collect(Collectors.toList());
    }
}