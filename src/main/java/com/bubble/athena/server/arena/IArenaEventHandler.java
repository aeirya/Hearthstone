package com.bubble.athena.server.arena;

import com.bubble.athena.net.arena.IArenaEvent;

public interface IArenaEventHandler {
    void handle(IArenaEvent event);
}