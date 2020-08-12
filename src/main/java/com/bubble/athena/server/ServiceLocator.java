package com.bubble.athena.server;

import com.bubble.athena.server.arena.IArena;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.util.log.IGameLogger;
import com.bubble.util.resource.IResourceManager;

public class ServiceLocator {
    private IUserManager userManager;
    private ILobby lobby;
    private IResourceManager resourceManager;
    private IArena arena; // remove this
    private IGameLogger logger;
    
    // becareful how you use this
    private static class InstanceHolder {
        private static final ServiceLocator instance = new ServiceLocator();
    }

    public static ServiceLocator getInstance() {
        return InstanceHolder.instance;
    }

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

    public ServiceLocator provideResources(IResourceManager resourceManager) {
        this.resourceManager = resourceManager;
        return this;
    }

    public static IResourceManager getResources() {
        return getInstance().resourceManager;
    }

    public ServiceLocator provideArena(IArena arena) {
        this.arena = arena;
        return this;
    }

    public IArena getArena() {
        return arena;
    }
    
    public ServiceLocator provideLogger(IGameLogger logger) {
        this.logger = logger;
        return this;
    }

    public static IGameLogger getLogger() {
        return getInstance().logger;
    }

}