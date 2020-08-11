package com.bubble.net.server;

import com.bubble.athena.server.user.OnlineUser;
import com.bubble.net.response.Response;

// choose a better name: like client response handler
public interface INetwork {
    void respond(String response, String auth);
    void respond(Response response, OnlineUser user);
    void start();
}
