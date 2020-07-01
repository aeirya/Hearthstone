package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.util.net.module.IServerNetworkConnection;

public interface IClient {
    int getID();
    IServerNetworkConnection getConnection();
}