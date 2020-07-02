package com.bubble.hearthstone.util.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileLoader implements IFileReader<String> {

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
                //
            }
        }
        return reader;
    }

    public String load() {
        final StringBuilder builder = new StringBuilder();
        final BufferedReader br = new BufferedReader(getReader());
        String line;
        try {
            while ((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            //
        }
        return builder.toString();
    }

    public String load(String path) {
        setPath(path);
        return load();
    }
}