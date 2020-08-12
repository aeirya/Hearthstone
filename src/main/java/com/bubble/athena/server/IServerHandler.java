package com.bubble.athena.server;

import com.bubble.athena.net.request.GameRequest;
import com.bubble.athena.net.request.IGameRequest;
import com.bubble.net.response.Response;

public interface IServerHandler {
    Response handleUserRequest(GameRequest request);
    Response handleLobbyRequest(IGameRequest request);
    Response handleArenaRequest(IGameRequest request);
}
