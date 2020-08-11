package com.bubble.athena.server;

import com.bubble.athena.server.user.IUserManager;

public class ServiceLocator {
    private IUserManager userManager;

    public ServiceLocator provideUserManager(IUserManager usermanager) {
        this.userManager = usermanager;
        return this;
    }

    public IUserManager getUserManager() {
        return userManager;
    }
}