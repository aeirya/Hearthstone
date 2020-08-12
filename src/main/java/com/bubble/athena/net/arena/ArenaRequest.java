package com.bubble.athena.net.arena;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;

public abstract class ArenaRequest extends GameRequest implements IArenaRequest {

    public ArenaRequest(NetRequest type, IGameEvent event) {
        super(type, event);
    }

    public ArenaRequest(Request req) {
        super(req);
    }

    @Override
    public Response apply(IServerHandler ser) {
        return ser.handleArenaRequest(this);
    }

}