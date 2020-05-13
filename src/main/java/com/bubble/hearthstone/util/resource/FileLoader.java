package com.bubble.hearthstone.util.resource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.bubble.hearthstone.util.services.ServiceLocator;

public class FileLoader extends ResourceLoader<String> {

    public String loadFile(String path) {
        try (
            InputStream is = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is))
        ){
            final StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } 
        catch(IOException e) {
            ServiceLocator.getLogger().error(this, e);
        }
        return null;
    }
}