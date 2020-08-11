package com.bubble.athena.net.arena;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.arena.IArena;
import com.bubble.net.response.Response;

public class ArenaRequest extends GameRequest implements IArenaRequest {

    public ArenaRequest(NetRequest type) {
        super(type);
    }

    @Override
    public Response apply(IArena arena) {
        // TODO Auto-generated method stub
        return null;
    }
    
}