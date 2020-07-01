package com.bubble.hearthstone.util.image;

import com.bubble.hearthstone.util.file.IFileReader;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

public class ImageLoader implements IFileReader<Map<String, Image>> {

    private static final ImageLoader instance = new ImageLoader();

    private ImageLoader() { }

    private static ImageLoader getInstance() { return instance; }

    public static Map<String, Image> get(String dir) {
        return getInstance().load(dir);
    }

    public Map<String, Image> load(String path) {
        final List<File> files = Arrays.asList(new File(path).listFiles());
        final Map<String, Image> images = new HashMap<>();
        files.forEach(
            file -> images.put(file.getName(), loadImage(file))
        );
        return images;
    } //iterating in the foldder, and then doing the same thiing as that

    private Image loadImage(File file) {
        Image image;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            ServiceLocator.getLogger().error(this, e);
            image = null;
        }
        return image;
    }

    //noting differences:
    //we have a singleton imageloader
    //2. we pass the ResourceConfig to CardLoader  --> gets its own dir --> iterates --> then loads based on type of resource
    //hmmmm..
    //while we pass directorypath to ImageLoader
}