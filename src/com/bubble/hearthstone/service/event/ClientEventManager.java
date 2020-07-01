package com.bubble.hearthstone.client.service.event;

import com.bubble.hearthstone.client.service.module.ModuleLocator;

public class ClientEventManager extends EventManager {

    public ClientEventManager(IEventHandler handler) {
        super(new ClientEventHandler());
    }
    
}