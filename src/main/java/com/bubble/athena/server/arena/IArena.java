package com.bubble.athena.server.arena;

import com.bubble.util.time.Time;

public interface IArena extends IArenaEventHandler {
    Time getTimePassed();
}