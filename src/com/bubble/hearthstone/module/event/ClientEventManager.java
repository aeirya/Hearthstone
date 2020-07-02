package com.bubble.hearthstone.module.event;

public class ClientEventManager extends EventManager {

    public ClientEventManager(IEventHandler handler) {
        super(new ClientEventHandler());
    }
    
}