package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.util.services.ServiceLocator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileWriter {
    
    private final String path;

    /** appends text to the end of string */
    public MyFileWriter(String path) {
        this.path = path;
    }

    public void write(String line) {
        try (
            final FileWriter fw = new FileWriter(path, true); 
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