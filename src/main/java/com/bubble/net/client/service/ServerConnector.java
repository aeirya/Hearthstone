package com.bubble.net.client.service;

import java.io.IOException;
import java.net.Socket;

class ServerConnector {
    private final String ip;
    private final int port;

    public ServerConnector(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Socket connect() {
        return connect(ip, port);
    }

    private Socket connect(String ip, int port) {
        try {
            return new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}