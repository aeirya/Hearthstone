package com.bubble.util.log;

import com.bubble.athena.server.ServiceLocator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileWriter {
    
    private String path;
    private final boolean append;

    public MyFileWriter() {
        this("");
    }

    public MyFileWriter(String path) {
        this(path, true);
    }

    public MyFileWriter(String path, boolean append) {
        this.path = path;
        this.append = append;
    }
    
    public MyFileWriter setPath(String path) {
        this.path = path;
        return this;
    }
    
    /** appends text to the end of string */
    public void write(String line) {
        try (
            final FileWriter fw = new FileWriter(path, append); 
            final BufferedWriter bw = new BufferedWriter(fw);
            final PrintWriter pw = new PrintWriter(bw)
        ) {
                pw.println(line);
        }
        catch (IOException e) {
            ServiceLocator.getLogger().error(this, e);
        }
    }
}