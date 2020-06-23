package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.client.GameClient;
import com.bubble.hearthstone.net.event.IEventProcessor;
import com.bubble.hearthstone.net.event.IGameEvent;

public interface IClientEvent extends IGameEvent {
    
    default void process(IEventProcessor processor) {
        process((GameClient) processor);
    }

    void process(GameClient client);
} 