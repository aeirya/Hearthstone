package com.bubble.net.server;

import com.bubble.net.request.Request;

public interface IRequestHandler {
    void handle(Request request);
}
