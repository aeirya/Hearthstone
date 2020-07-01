package com.bubble.hearthstone.util.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import com.bubble.hearthstone.util.services.ServiceLocator;

public class FileLoader implements IFileReader<List<String>> {

    private Reader reader;
    private String path;

    public FileLoader(String path) {
        setPath(path);
    }

    private void setPath(String path) {
        this.path = path;
    }

    public Reader getReader() {
        if (reader == null) {
            try {
                reader = new FileReader(path);
            } catch (FileNotFoundException e) {
                ServiceLocator.getLogger().error(this, e);
            }
        }
        return reader;
    }

    public List<String> load() {
        final BufferedReader br = new BufferedReader(getReader());
        final List<String> list = new LinkedList<>();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            ServiceLocator.getLogger().error(this, e);
        }
        return list;
    }

    public List<String> load(String path) {
        setPath(path);
        return load();
    }
}