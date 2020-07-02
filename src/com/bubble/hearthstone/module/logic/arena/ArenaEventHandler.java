package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventHandler;

public class ArenaEventHandler implements IEventHandler {

    private final Arena arena;

    public ArenaEventHandler(Arena arena) {
        this.arena = arena;
    }

    @Override
    public void handle(IEvent event) {
        event.process(this);
    }

    public void onPlayerEnter(IEvent event) {
        arena.dispatch(event);
    }
}