package com.bubble.util.reflection;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class AutomaticClassLoader extends URLClassLoader {

    public AutomaticClassLoader(File file) throws MalformedURLException {
        super(new URL[] { file.toURI().toURL() });
        load(file);
    }

    public AutomaticClassLoader(String path) throws MalformedURLException {
        this(new File(path));
    }

    private void load(File file) {
        try (JarFile jar = new JarFile(file)) {
            loadAllClasses(jar.entries());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAllClasses(Enumeration<JarEntry> entries) {
        while (entries.hasMoreElements()) {
            try {
                load(entries.nextElement());
            } catch (ClassNotFoundException e) {
                // bad things just happen :p
            }
        }
    }

    private void load(JarEntry entry) throws ClassNotFoundException {
        this.loadClass(getClassname(entry));
    }

    private String getClassname(JarEntry entry) {
        return entry.getName().replace("/", ".").replace(".class", "");
    }
}