package com.bubble.athena.net.request;

import com.bubble.athena.server.IServerHandler;
import com.bubble.net.response.Response;

public interface IRequest {
    Response apply(IServerHandler server);
}