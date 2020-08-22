package com.bubble.athena.net.lobby;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.IServerHandler;
import com.bubble.net.response.Response;

public abstract class LobbyRequest extends GameRequest implements ILobbyRequest {

    protected String user;

    protected LobbyRequest(NetRequest type) {
        super(type);
    }

    protected LobbyRequest(NetRequest type, String user) {
        super(type);
        this.user = user;
    }

    @Override
    public Response apply(IServerHandler ser) {
        return ser.handleLobbyRequest(this);
    }
}