package com.bubble.hearthstone.server.framework.module;

import com.bubble.hearthstone.client.service.event.EventManager;
import com.bubble.hearthstone.client.service.event.IEventHandler;
import com.bubble.hearthstone.server.GameServer;
import com.bubble.hearthstone.server.framework.network.INetwork;

public class ModuleManager {

    private final INetwork network;
    private final EventManager eventManager;

    public ModuleManager(GameServer server) {
        network = initiateNetwork();
        eventManager = initiateEventManager(server);

        
    }

    private INetwork initiateNetwork() {
        return null;
    }

    private EventManager initiateEventManager(IEventHandler handler) {
        return new EventManager(handler);
    }
}