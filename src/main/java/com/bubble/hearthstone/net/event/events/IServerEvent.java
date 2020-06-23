package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.event.IEventProcessor;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.server.IGameServer;

public interface IServerEvent extends IGameEvent {
    
    default void process(IEventProcessor processor) {
        process((IGameServer) processor);
    }

    void process(IGameServer server);
} 