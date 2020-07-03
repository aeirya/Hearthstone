package com.bubble.hearthstone.module.service;

import com.bubble.hearthstone.module.logic.user.IUserManager;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class ServiceLocator {
    private ResourceManager resourceManager;
    private IUserManager userManager;

    private static class InstanceHolder {
        private static final ServiceLocator instance = new ServiceLocator();
    }

    public static ServiceLocator getInstance() {
        return InstanceHolder.instance;
    }

    public ServiceLocator provideResources(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
        return this;
    }

    public static ResourceManager getResources() {
        return getInstance().resourceManager;
    }

    public static IUserManager getUserManager() {
        return getInstance().userManager;
    }
}