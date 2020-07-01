package com.bubble.hearthstone.server.arena;

import com.bubble.hearthstone.client.service.event.IEvent;
import com.bubble.hearthstone.client.service.event.IEventHandler;

public interface IArenaEvent extends IEvent {
    default void process(IEventHandler handler) {
        if (handler instanceof Arena) {
            handler.handle(this);
        }
    }

    void process(Arena arena);
}