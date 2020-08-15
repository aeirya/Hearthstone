package com.bubble.athena.net.arena;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.net.response.Response;

public abstract class ArenaRequest extends GameRequest implements IArenaRequest {

    protected IArenaEvent event;
    
    public ArenaRequest(NetRequest type, IArenaEvent event) {
        super(type);
        this.event = event;
    }

    public ArenaRequest(NetRequest type) {
        super(type);
    }

    @Override
    public Response apply(IServerHandler ser) {
        return ser.handleArenaRequest(this);
    }
}