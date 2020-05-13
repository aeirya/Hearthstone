package com.bubble.hearthstone.util.resource;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bubble.hearthstone.util.config.Config;

public abstract class ResourceLoader<T> {
    
    protected final Config resourceConfig;

    public ResourceLoader(Config resourceConfig) {
        this.resourceConfig = resourceConfig;
    }

    protected abstract String getKey();

    protected String getPath() {
        final String key = getKey();
        final String path = resourceConfig.getProperty(key);
        return findPath(path);
    }

    protected static String findPath(String path) {
        if (pathExists(getFileInData(path))) {
            return getFileInData(path);
        }
        else return getFileInClassPath(path);
    }

    private static boolean pathExists(String path) {
        return new File(path).exists();
    }

    private static String getFileInData(String path) {
        return "data/" + path;
    }

    private static String getFileInClassPath(String path) {
        return ResourceLoader.class.getClassLoader().getResource(path).getFile();
    }
    
    public Map<String, T> load() {
        return load(getPath());
    }

    private Map<String, T> load(String path) {
        final Map<String, T> map = new HashMap<>();
        listFiles(path).forEach(
            file -> map.put(file.getName(), loadResource(path))
        );
        return map;
    }

    protected abstract T loadResource(String path);

    private List<File> listFiles(String path) {
        final File dir = new File(
            path
        );
        File[] files = dir.listFiles();
        return Arrays.asList(files);
    }

    // private List<File> filter

    //TODO: make image loader extend this
}