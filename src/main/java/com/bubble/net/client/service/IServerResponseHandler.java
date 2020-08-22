package com.bubble.net.client.service;

public interface IServerResponseHandler {
    void handle(String response);
    void bye();
}