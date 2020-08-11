package com.bubble.athena.net.request;

import com.bubble.athena.server.IServerHandler;
import com.bubble.net.response.Response;

// i could be using this instead of game request
public interface IGameRequest {
    Response apply(IServerHandler server);
    // NetRequest getType();
}