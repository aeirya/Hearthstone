package com.bubble.hearthstone.module.service;

import com.bubble.hearthstone.module.logic.user.UserManager;

public class ServiceManager {
    // private final ResourceManager resourceManager;
    private final UserManager userManager;

    public ServiceManager() {
        userManager = new UserManager(this);
    }

    public UserManager getUserManager() {
        return userManager;
    }

}