package com.bubble.hearthstone.util.resource;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bubble.hearthstone.util.services.ServiceLocator;

public class ImageLoader extends ResourceLoader<Image> {

    public Image loadFile(String path) {
        final File file = new File(path);
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            ServiceLocator.getLogger().error(this, e);
        }
        return null;
    }
}