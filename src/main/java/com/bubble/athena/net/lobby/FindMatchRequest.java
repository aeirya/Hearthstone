package com.bubble.athena.net.lobby;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.request.Request;
import com.bubble.net.response.Response;

public class FindMatchRequest extends LobbyRequest {

    public FindMatchRequest(String user) {
        super(NetRequest.FIND_MATCH, user);
    }

    public FindMatchRequest(Request request) {
        super(request);
    }

    private String getUser() {
        return body;
    }

    @Override
    public Response apply(ILobby lobby) {
        lobby.findMatch(getUser());
        return Response.OK;
    }
}