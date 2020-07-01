package com.bubble.hearthstone.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import com.bubble.hearthstone.client.service.event.IEvent;

public class NetworkConnection implements INetworkConnection {

    private Socket socket;
    private final NetworkDispatcher dispatcher;
    private final NetworkListener listener;
    
    private final String host;
    private final int port;

    public NetworkConnection(String host, int port) {
        this.host = host;
        this.port = port;
        dispatcher = new NetworkDispatcher(socket);
        listener = new NetworkListener(socket);
    }

    private Socket initiateSocket(String host, int port) {
        try {
            return new Socket(host, port);
        } catch (IOException e) {
            return null;
        }
    }

    public void start() {
        socket = initiateSocket(host, port);
        dispatcher.start();
        listener.start();
    }

    @Override
    public void dispatch(IEvent event) {
        dispatcher
    }
}