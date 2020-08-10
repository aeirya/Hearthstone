package com.bubble.net.client.service;

import java.net.Socket;

import com.bubble.net.connection.INetworkReceiver;
import com.bubble.net.connection.NetworkConnection;

class Server implements INetworkReceiver {

    private final NetworkConnection connection;
    private final IServerResponseHandler handler;

    public Server(IServerResponseHandler handler, Socket socket) {
        this.handler = handler;
        this.connection = new NetworkConnection(this, socket);
        this.connection.start();
    }

    public void receive(String data) {
        handler.handle(data);
    }

    public void send(String data) {
        connection.send(data);
    }

    public void terminate() {
        handler.bye();
    }
}