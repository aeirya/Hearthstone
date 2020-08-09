package com.bubble.hearthstone.net.event.events.arena;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public abstract class ArenaEvent implements IGameEvent {

    public void process(GameManager manager) {
        manager.handleArenaEvent(this);
    }

    public abstract void process(Arena arena);
}