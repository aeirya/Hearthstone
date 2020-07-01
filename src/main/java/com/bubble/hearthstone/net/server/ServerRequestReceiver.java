package com.bubble.hearthstone.net.server;

import java.util.LinkedList;

import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IServerNetworkConnection;

public class ServerRequestReceiver implements Runnable {
    private final IServerNetworkConnection connection;
    private final LinkedList<IRequest> requests;
    
    public ServerRequestReceiver() {
        requests = new LinkedList<>();
        connection = null;
    }

    public void run() {
        new Thread(
            () -> {
                final IRequest request = receive();
                if (request != null) queue(request);
            }
        ).start();
    }

    private IRequest receive() {
        return connection.get();
    }

    private void queue(IRequest request) {
        requests.add(request);
    }

    public IRequest get() {
        return requests.removeFirst();
    }
}