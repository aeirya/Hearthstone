package com.bubble.athena.server;

import com.bubble.athena.server.lobby.ILobby;
import com.bubble.athena.server.user.IUserManager;

public class ServiceLocator {
    private IUserManager userManager;
    private ILobby lobby;
    
    public ServiceLocator provideUserManager(IUserManager usermanager) {
        this.userManager = usermanager;
        return this;
    }

    public IUserManager getUserManager() {
        return userManager;
    }

    public ServiceLocator provideLobby(ILobby lobby) {
        this.lobby = lobby;
        return this;
    }

    public ILobby getLobby() {
        return lobby;
    }
}