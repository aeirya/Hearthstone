
package com.bubble.hearthstone.util.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bubble.hearthstone.util.config.ResourceConfig;

public class FileManager {

    private final ResourceConfig config;

    public FileManager(ResourceConfig config) {
        this.config = config;
    }

    public void createFoldersIfNeeded() {
        config.getAll().forEach(
            v -> {
                try {
                    Files.createDirectories(Paths.get(v));
                } catch (IOException e) {
                    //
                }
            }
        );
    }   
}