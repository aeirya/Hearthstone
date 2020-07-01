package com.bubble.hearthstone.net.event.events.arena;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.net.event.events.IServerEvent;
import com.bubble.hearthstone.net.server.IGameServer;

public interface IArenaEvent extends IServerEvent {

    default void process(IGameServer server) {
        server.handleArenaEvent(this);
    }

    void process(Arena arena);
}