package com.bubble.hearthstone.util.services;

import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class ServiceLocator {
    
    private GameLogger logger;
    private ResourceManager resourceManager;

    private static class InstanceHolder {
        private static final ServiceLocator instance = new ServiceLocator();
    }

    public static ServiceLocator getInstance() {
        return InstanceHolder.instance;
    }

    private ServiceLocator() { }

    public ServiceLocator provideLogger(GameLogger logger) {
        this.logger = logger;
        return this;
    }

    public static GameLogger getLogger() {
        return getInstance().logger;
    }

    public ServiceLocator provideResources(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
        return this;
    }

    public static ResourceManager getResources() {
        return getInstance().resourceManager;
    }
}