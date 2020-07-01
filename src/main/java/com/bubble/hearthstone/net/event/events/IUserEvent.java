package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.server.IGameServer;
import com.bubble.hearthstone.net.user.registry.IUserManager;

@FunctionalInterface
public interface IUserEvent extends IServerEvent {
    void process(IUserManager userManager);
    
    default void process(IGameServer server) {
        server.handleUserEvent(this);
    }
}