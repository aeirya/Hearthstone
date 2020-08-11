package com.bubble.athena.net.lobby;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;

public abstract class LobbyRequest extends GameRequest implements ILobbyRequest {

    public LobbyRequest(NetRequest type, Object obj) {
        super(type, obj);
    }

    public LobbyRequest(NetRequest type, String user) {
        super(type, user);
    }

    public LobbyRequest(Request request) {
        super(request);
    }

    protected String getUser() {
        return body;
    }

    @Override
    public Response apply(IServerHandler ser) {
        return ser.handleLobbyRequest(this);
    }
}