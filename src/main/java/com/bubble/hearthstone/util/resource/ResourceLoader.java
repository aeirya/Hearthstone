package com.bubble.hearthstone.util.resource;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ResourceLoader<T> {

    public Map<String, T> loadDir(String dir) {
        final Map<String, T> map = new HashMap<>();
        listFiles(dir).forEach(
            file -> map.put(file.getName(), loadFile(file.getPath()))
        );
        return map;
    }

    private List<File> listFiles(String path) {
        final File dir = new File(
            path
        );
        File[] files = dir.listFiles();
        return Arrays.asList(files);
    }
        
    public abstract T loadFile(String path);
    
    //TODO: make image loader extend this
}