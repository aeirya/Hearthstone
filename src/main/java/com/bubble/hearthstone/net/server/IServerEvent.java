package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.net.event.IEventProcessor;
import com.bubble.hearthstone.net.event.IGameEvent;

public interface IServerEvent extends IGameEvent {
    
    default void process(IEventProcessor processor) {
        process((IGameServer)this);
    }

    void process(IGameServer server);
}