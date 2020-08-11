package com.bubble.net.server.client;

import java.net.Socket;

import com.bubble.net.connection.INetworkReceiver;
import com.bubble.net.connection.NetworkConnection;

public class Client implements INetworkReceiver {
    private final NetworkConnection connection;
    private final IClientRequestHandler server;
    private String auth;

    public Client(Socket socket, IClientRequestHandler server) {
        this.server = server;
        connection = new NetworkConnection(this, socket);
    }

    public void start() {
        connection.start();
    }

    public void receive(String data) {
        server.request(this, data);
    }

    public void send(String data) {
        connection.send(data);    
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }

    public void terminate() {
        server.bye(this);
    }
}