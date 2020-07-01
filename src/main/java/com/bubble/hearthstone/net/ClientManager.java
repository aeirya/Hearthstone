package com.bubble.hearthstone.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bubble.hearthstone.net.server.IClient;
import com.bubble.hearthstone.util.net.module.ClientToken;
import com.bubble.hearthstone.util.net.module.INetworkConnection;

public class ClientManager {
    
    private final Map<IClient, INetworkConnection> connections;
    
    public ClientManager() {
        connections = new HashMap<>();
    }

    private List<IClient> getClients() {
        return new ArrayList<>(connections.keySet());
    }

    public IClient findClient(ClientToken token) {
        return findClient(token.getID());
    }

    private IClient findClient(int id) {
        for (IClient client : getClients()) {
            if (client.getID() == id) return client;
        }
        return null;
    }

    public INetworkConnection getConnection(IClient client) {
        return connections.get(client);
    }
    //TODO: make this now
}

/*
    server.respond

    client.getResponse

    
*/

