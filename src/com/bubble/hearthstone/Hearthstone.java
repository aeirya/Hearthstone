package com.bubble.hearthstone;

import com.bubble.hearthstone.module.service.ServiceLocator;
import com.bubble.hearthstone.util.resource.FileManager;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class Hearthstone implements Runnable {
    
    private final String configPath;

    public static void main(String... args) {
        new Hearthstone(args).run();
    }

    public Hearthstone(String[] args) {
        if (args.length > 0) {
            configPath = args[0];
        }
        else configPath = FileManager.findInClasspath("config/files.properties");
    }

    public void run() {
        initiateServiceLocator();
        new Game().start();
    }

    private void initiateServiceLocator() {
        final ResourceManager resourceManager = new ResourceManager(configPath);
        ServiceLocator
            .getInstance()
            .provideResources(resourceManager);
    }
}