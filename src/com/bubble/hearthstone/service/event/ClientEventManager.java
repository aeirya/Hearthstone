package com.bubble.hearthstone.service.event;

import com.bubble.hearthstone.service.module.ModuleLocator;

public class ClientEventManager extends EventManager {

    public ClientEventManager(IEventHandler handler) {
        super(new ClientEventHandler());
    }
    
}