package com.bubble.net.server.client;

public interface IClientRequestHandler {
    void request(Client client, String data);
    void bye(Client client);
}