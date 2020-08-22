package com.bubble.athena.net.lobby;

import com.bubble.athena.server.lobby.ILobby;
import com.bubble.net.response.Response;

@FunctionalInterface
public interface ILobbyRequest {
    Response apply(ILobby lobby);
}