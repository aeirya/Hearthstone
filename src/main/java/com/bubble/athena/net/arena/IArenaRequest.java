package com.bubble.athena.net.arena;

import com.bubble.athena.server.arena.IArena;
import com.bubble.net.response.Response;

public interface IArenaRequest {
    Response apply(IArena arena);
}