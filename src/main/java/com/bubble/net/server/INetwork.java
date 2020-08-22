package com.bubble.net.server;

// choose a better name: like client response handler
public interface INetwork {
    void respond(String response, String auth);
    void start();
}
