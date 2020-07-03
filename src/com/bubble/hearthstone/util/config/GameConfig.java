package com.bubble.hearthstone.util.config;

import com.bubble.hearthstone.stl.Dimension;

public class GameConfig extends Config {

public GameConfig(ResourceConfig config) {
        this(config.getSettingsFolder());
    }

    public GameConfig(String path) {
        super(path);
    }

    public Dimension getResolution() {
        final String resolution =  get(Fields.RESOLUTION);
        final String[] s = resolution.split("x");
        final String x = s[0];
        final String y = s[1];
        return new Dimension(
            Integer.valueOf(x), 
            Integer.valueOf(y)
            );
    }

    public String get(Fields field) {
        final String key = parse(field);
        return config.getProperty(key);
    }

    private String parse(Fields field) {
        switch(field) {
            case RESOLUTION:
            return "resolution";
            case ISMUTE:
            return "mute";
            default:
            return "";
        }
    }

    enum Fields {
        RESOLUTION,
        ISMUTE,
    }
}