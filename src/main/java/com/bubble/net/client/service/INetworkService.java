package com.bubble.net.client.service;

public interface INetworkService extends IServerResponseHandler {
    void connect();
    void send(String data);
    String getNext();
}