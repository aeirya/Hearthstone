package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.util.services.ServiceLocator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileWriter {
    
    private String path;

    public MyFileWriter() {
        this("");
    }

    public MyFileWriter(String path) {
        this.path = path;
    }

    public MyFileWriter setPath(String path) {
        this.path = path;
        return this;
    }
    
    /** appends text to the end of string */
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
    
    // public void writeFile(String text) {
    //     try (
    //         final FileWriter fw = new FileWriter(path);
    //         ) {
    //             fw.write(text);
    //         } 
    //     catch (IOException e) {
    //         ServiceLocator.getLogger().error(this, e);
    //     }
    // }
}