package com.bubble.util.reflection;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.stream.Collectors;

public class CustomClassLoader {

    public List<Class<?>> load(String path, List<String> names) {
        return names.stream().map(name -> load(path, name)).collect(Collectors.toList());
    }

    public Class<?> load(String path, String name) {
        try (URLClassLoader loader = getLoader(path)) {
            return loader.loadClass(name);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private URLClassLoader getLoader(String... paths) {
        return new URLClassLoader(getUrl(paths));
    }

    private URL[] getUrl(String... paths) {
        URL[] urls = new URL[paths.length];
        for (int i = 0; i < urls.length; i++) {
            urls[i] = getUrl(paths[i]);
        }
        return urls;
    }

    private URL getUrl(String path) {
        try {
            return (new File(path)).toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}