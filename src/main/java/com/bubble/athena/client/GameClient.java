package com.bubble.athena.client;

import com.bubble.athena.client.net.ServerAPI;
import com.bubble.net.client.Network;

public class GameClient {

    protected final Network network;
    protected final ServerAPI server;

    public GameClient(String ip, int port) {
        network = new Network(ip, port);
        server = new ServerAPI(network);
    }

    public void run() {
        network.connect();
    }

    public ServerAPI get() {
        return server;
    }
}
