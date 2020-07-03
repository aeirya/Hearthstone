package com.bubble.hearthstone;

import com.bubble.hearthstone.util.config.ResourceConfig;

public class Hearthstone implements Runnable {
    
    private final String configPath;

    public static void main(String... args) {
        new Hearthstone(args).run();
    }

    public Hearthstone(String[] args) {
        if (args.length > 0) {
            configPath = args[0];
        }
        else configPath = "config/files.properties";
    }

    public void run() {
        final ResourceConfig config = new ResourceConfig(configPath);
        new Game().start();
    }
}