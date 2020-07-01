package com.bubble.hearthstone.server;

import com.bubble.hearthstone.client.service.event.EventManager;
import com.bubble.hearthstone.client.service.event.IEvent;
import com.bubble.hearthstone.server.framework.module.ModuleManager;

public class GameServer implements IGameServer {

    private final EventManager eventManager;
    private final ModuleManager modules;

    public GameServer() {
        eventManager = new EventManager(this);
        modules = new ModuleManager(this);
    }

    public void run() {
        //
    }

    @Override
    public void handle(IEvent event) {
        
    }
}