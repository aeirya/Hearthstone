package com.bubble.util.resource;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IResourceLoader<T> {

    public default Map<String, T> loadDir(String dir) {
        final Map<String, T> map = new HashMap<>();
        listFiles(dir).forEach(
            file -> map.put(getFileName(file), loadFile(file.getPath()))
        );
        return map;
    }

    private String getFileName(File file) {
        return file.getName().split("\\.")[0];
    }

    private List<File> listFiles(String path) {
        final File dir = new File(
            path
        );
        File[] files = dir.listFiles();
        return Arrays.asList(files);
    }
        
    public abstract T loadFile(String path);
}