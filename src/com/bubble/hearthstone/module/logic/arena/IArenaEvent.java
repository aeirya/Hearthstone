package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventHandler;

public interface IArenaEvent extends IEvent {
    default void process(IEventHandler handler) {
        if (handler instanceof Arena) {
            handler.handle(this);
        }
    }

    void process(Arena arena);
}