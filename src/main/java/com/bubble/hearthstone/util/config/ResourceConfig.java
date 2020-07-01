package com.bubble.hearthstone.util.config;

import java.awt.Image;
import java.util.Map;

import com.bubble.hearthstone.util.image.ImageLoader;

public class ResourceConfig {

    private final Config config;
    private final Map<String, Image> images;

    public ResourceConfig(Config filesConfig) {
        config = filesConfig;
        images = loadImages();
    }

    private Map<String, Image> loadImages() {
        return ImageLoader.get(config.getProperty("image"));
    }

    public Image getImage(String name) {
        return images.get(name);
    }

    //and this for images
    //anyway, i guess there's no more need for this object
}