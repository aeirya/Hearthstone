package com.bubble.hearthstone;

import com.bubble.hearthstone.module.logic.user.IUserManager;
import com.bubble.hearthstone.module.logic.user.UserManager;
import com.bubble.hearthstone.module.service.ServiceLocator;
import com.bubble.hearthstone.util.log.ColoredGameLogger;
import com.bubble.hearthstone.util.log.GameLogger;
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
        else configPath = "data/config/file.properties";
    }

    public void run() {
        initiateServiceLocator();
        new Game().start();
    }

    private void initiateServiceLocator() {
        final ResourceManager resourceManager = new ResourceManager(configPath);
        final GameLogger logger = new ColoredGameLogger();
        final ServiceLocator services = ServiceLocator.getInstance();
        final IUserManager userManager = new UserManager(services);
        services
            .provideResources(resourceManager)
            .provideUserManager(userManager)
            .provideLogger(logger);
    }
}