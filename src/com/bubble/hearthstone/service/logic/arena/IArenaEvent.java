package com.bubble.hearthstone.service.logic.arena;

import com.bubble.hearthstone.service.event.IEvent;
import com.bubble.hearthstone.service.event.IEventHandler;

public interface IArenaEvent extends IEvent {
    default void process(IEventHandler handler) {
        if (handler instanceof Arena) {
            handler.handle(this);
        }
    }

    void process(Arena arena);
}