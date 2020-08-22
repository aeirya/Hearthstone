package com.bubble.hearthstone.net2.event.events.arena;

import com.bubble.hearthstone.controller.Arena;

public interface IArenaEvent {
    void process(Arena arena);
}