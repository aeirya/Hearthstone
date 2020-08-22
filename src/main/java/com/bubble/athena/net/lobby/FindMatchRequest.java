package com.bubble.athena.net.lobby;

import com.bubble.athena.net.request.NetRequest;
import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.response.Response;

public class FindMatchRequest extends LobbyRequest {

    public FindMatchRequest(String user) {
        super(NetRequest.FIND_MATCH, user);
    }

    @Override
    public Response apply(ILobby lobby) {
        lobby.findMatch(user);
        return Response.OK;
    }
}